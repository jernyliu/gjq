package com.chinamobile.js.sz.tvms.access.service.impl;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.access.service.AccessService;
import com.chinamobile.js.sz.tvms.access.vo.LoginUserVO;
import com.chinamobile.js.sz.tvms.common.exception.BusinessException;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysFunc;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.syscfg.service.SysCodeService;
import com.chinamobile.js.sz.tvms.syscfg.service.SysFuncService;
import com.chinamobile.js.sz.tvms.syscfg.service.SysOperatorService;
import com.chinamobile.js.sz.tvms.syscfg.service.SysOrgService;
import com.chinamobile.js.sz.tvms.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private SysOperatorService sysOperatorService;

    @Autowired
    private SysFuncService sysFuncService;

    @Autowired
    private SysCodeService sysCodeService;

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private SystemUtil systemUtil;


    @Override
    public LoginUserVO processLogin(String operatorId, String password) {
        LoginUserVO loginUserVO = new LoginUserVO();
        //is userId 11 or 90
        SysOperator sysOperator;
        String operatorIdSub;
        if(3 > operatorId.length()) {
            operatorIdSub = operatorId;
        } else {
            operatorIdSub = operatorId.substring(0, 2);
        }
        if(!"90".equals(operatorIdSub)){
            operatorIdSub = "11"+operatorId;
            operatorId = operatorIdSub;

        }
        //get user
        try {
            sysOperator = sysOperatorService.getOperator(Long.valueOf(operatorId));
        } catch (Exception e) {
            throw new BusinessException("errors.access.login.userExcep");
        }

        //validate user log in
        if(sysOperator==null) {
            throw new BusinessException("errors.access.login.userExcep");
        }
        if(!sysOperator.getOperatorPwd().equals(password)) {
            throw new BusinessException("errors.access.login.pwdExcep");
        }
        if (sysOperator.getSysRoles()==null || sysOperator.getSysRoles().isEmpty()) {
            throw new BusinessException("errors.access.login.userRoleExcep");
        }
        if(sysOperator.getStatusId().equals(TvmsTypes.NOT_ACTIVE)) {
            throw new BusinessException("errors.access.login.userStatusExcep");
        }
//		if(sysOperator.getInvalidTime().compareTo(new Date()) < 0) {
//            throw new BusinessException("errors.access.login.userInvaild");
//        }

        if(sysOperator.getSysOrg() == null) {
            throw new BusinessException("errors.access.login.userOrgNullExcep");
        }

        sysOperator = checkLoginUserRoles(sysOperator);
        if (sysOperator.getSysRoles()==null || sysOperator.getSysRoles().isEmpty()) {
            throw new BusinessException("errors.access.login.userRoleExcep");
        }
        //set loginUserVO
        loginUserVO.setOperatorId(sysOperator.getOperatorId());
        loginUserVO.setOperatorName(sysOperator.getOperatorName());
        loginUserVO.setOrgId(sysOperator.getSysOrg().getOrgId());
        loginUserVO.setOrgName(sysOperator.getSysOrg().getOrgName());
        loginUserVO.setCityId(sysOperator.getSysOrg().getCountyId());
        String cityName = sysCodeService.getSysCodeDesc("CITY", loginUserVO.getCityId());
        loginUserVO.setCityName(cityName);
        Boolean isSellsDept = sysOrgService.isSellsDept(loginUserVO.getOrgId());
        loginUserVO.setSalesDept(isSellsDept);

        // set loginUserVO.RoleId
        Set<Long> userRoleFuncs = new HashSet<>();
        Long[] userRoleIds = new Long[sysOperator.getSysRoles().size()];
        for (int i = 0; i < sysOperator.getSysRoles().size(); i++) {
            SysRole sysRole =  sysOperator.getSysRoles().get(i);
            // set loginUserVO.RoleId
            userRoleIds[i] = sysRole.getRoleId();
            //set user Funcs in HashSet()
                for (SysFunc  sysFunc : sysRole.getSysFuncs()) {
                    userRoleFuncs.add(sysFunc.getFuncId());
                }
        }
        loginUserVO.setRoleIds(userRoleIds);

        // func.
        List<SysFunc> grantedSysFuncTree =  sysFuncService.buildRoleSysFuncTree(userRoleFuncs);
        loginUserVO.setGrantedFuncTree(grantedSysFuncTree);

        return loginUserVO;
    }

    @Override
    public void processLogout(Long operatorId) {

    }

    @Override
    public LoginUserVO checkLoginUser(String operatorId) {
        SysOperator sysOperator;
        String operatorIdSub;
        if (3 > operatorId.length()) {
            operatorIdSub = operatorId;
        } else {
            operatorIdSub = operatorId.substring(0, 2);
        }
        if (!"90".equals(operatorIdSub)) {
            operatorIdSub = "11" + operatorId;
            operatorId = operatorIdSub;
        }

        //get user
        try {
            sysOperator = sysOperatorService.getOperator(Long.valueOf(operatorId));
            DateFormat df = new SimpleDateFormat(systemUtil.getString("date.format.display", "yyyy-MM-dd"));
            String nowDateStr = df.format(new Date());
            //validate user log in
            if (sysOperator == null || sysOperator.getSysOrg() == null
                    || sysOperator.getSysRoles() == null
                    || sysOperator.getSysRoles().isEmpty() || sysOperator.getStatusId() == 0
                /*|| nowDateStr.compareTo(DateUtil.convertDateToString(TvmsTypes.DATE_PATTERN_DISPLAY, sysOperator.getInvalidTime())) > 0*/) {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

        //set loginUserVO
        LoginUserVO loginUserVO = new LoginUserVO();
        loginUserVO.setOperatorId(sysOperator.getOperatorId());
        loginUserVO.setOperatorName(sysOperator.getOperatorName());
        loginUserVO.setOrgId(sysOperator.getSysOrg().getOrgId());
        loginUserVO.setOrgName(sysOperator.getSysOrg().getOrgName());
        loginUserVO.setCityId(sysOperator.getSysOrg().getCountyId());

        String cityName = sysCodeService.getSysCodeDesc("CITY", loginUserVO.getCityId());
        loginUserVO.setCityName(cityName);
        Boolean isSellsDept = sysOrgService.isSellsDept(loginUserVO.getOrgId());
        loginUserVO.setSalesDept(isSellsDept);

        // set loginUserVO.RoleId
        Set<Long> userRoleFuncs = new HashSet<>();
        Long[] userRoleIds = new Long[sysOperator.getSysRoles().size()];
        for (int i = 0; i < sysOperator.getSysRoles().size(); i++) {
            SysRole sysRole =  sysOperator.getSysRoles().get(i);
            // set loginUserVO.RoleId
            userRoleIds[i] = sysRole.getRoleId();
            //set user Funcs in HashSet()
                for (SysFunc sysFunc: sysRole.getSysFuncs()) {
                    userRoleFuncs.add(sysFunc.getFuncId());
                }
        }
        loginUserVO.setRoleIds(userRoleIds);

        // func.
        List<SysFunc> grantedSysFuncTree =  sysFuncService.buildRoleSysFuncTree(userRoleFuncs);
        loginUserVO.setGrantedFuncTree(grantedSysFuncTree);

        return loginUserVO;
    }

    private SysOperator checkLoginUserRoles(SysOperator sysOperator) {
        List<SysRole> roles = sysOperator.getSysRoles();
        List<SysRole> activeRoles = new ArrayList<>();
        for(SysRole sysRole : roles) {
            if(TvmsTypes.IS_ACTIVE.equals(sysRole.getIsActive())) {
                activeRoles.add(sysRole);
            }
        }
        sysOperator.setSysRoles(activeRoles);
        return sysOperator;
    }
}
