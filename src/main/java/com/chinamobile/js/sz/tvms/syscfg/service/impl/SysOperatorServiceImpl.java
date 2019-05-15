package com.chinamobile.js.sz.tvms.syscfg.service.impl;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.common.exception.BusinessException;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysOperatorMapper;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysRoleMapper;
import com.chinamobile.js.sz.tvms.syscfg.service.SysOperatorService;
import com.chinamobile.js.sz.tvms.syscfg.vo.SysOperatorMessageVO;
import com.chinamobile.js.sz.tvms.utils.KeyValue;
import com.chinamobile.js.sz.tvms.utils.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysOperatorServiceImpl implements SysOperatorService {

    @Autowired
    private SysOperatorMapper sysOperatorMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SystemUtil systemUtil;

    @Override
    public SysOperatorMessageVO getEditOperator(Long id) {
        SysOperator sysOperator = sysOperatorMapper.getOperator(id);
        Map<String, String> sysRoleMap = new HashMap<>();
        List<SysRole> sysRoleList = new ArrayList<>();
        //get all role
        List<SysRole> allRoleList = sysRoleMapper.getAllSysRoleByParam(new KeyValue("isActive", 1));
        String disableRoleIds = systemUtil.getString("disable.role.id", "1,2,3");
        String[] disableRoleIdList = disableRoleIds.split(",");
        for (String disableRoleId : disableRoleIdList) {
            sysRoleMap.put(disableRoleId, disableRoleId);
        }
        for (SysRole role: allRoleList) {
            String tmpRoleString = role.getRoleId().toString();
            if(!sysRoleMap.containsKey(tmpRoleString)) {
                sysRoleList.add(role);
            }
        }
        //save operatorMessageVO, operatroMessageVO is DynaValidatorActionForm.
        SysOperatorMessageVO sysOperatorMessageVO = new SysOperatorMessageVO();
        sysOperatorMessageVO.setOperatorId(sysOperator.getOperatorId());
        sysOperatorMessageVO.setShortNo(sysOperator.getShortNo());
        sysOperatorMessageVO.setOperatorName(sysOperator.getOperatorName());
        sysOperatorMessageVO.setContactTel(sysOperator.getMobile());
        sysOperatorMessageVO.setContactTel(sysOperator.getOaName());
        if(sysOperator.getSysOrg() != null) {
            sysOperatorMessageVO.setOrgName(sysOperator.getSysOrg().getOrgName());
        } else {
            sysOperatorMessageVO.setOrgName("--");
        }
        List<SysRole> roleList = sysOperator.getSysRoles();
        String selectRoleString;
        String unSelectRoleString;

        StringBuilder roleNameString = new StringBuilder();
        List<KeyValue> selectRoleList = new ArrayList<>();
        List<KeyValue> unSelectRoleList = new ArrayList<>();
        for (SysRole role : roleList) {
            //save roleNameString
            roleNameString.append(role.getRoleName()).append(",");
            //save selectRoleList
            selectRoleList.add(new KeyValue(role.getRoleName(), role.getRoleId().toString()));
        }
        roleNameString.deleteCharAt(roleNameString.length()-1);

        //save unSelectRoleList
        boolean is = true;
        for(SysRole role1: sysRoleList){
            is = false;
            for(SysRole role2: roleList){
                unSelectRoleString = role1.getRoleId().toString();
                selectRoleString = role2.getRoleId().toString();
                if(selectRoleString.equals(unSelectRoleString)){
                    is = true;
                    break;
                }
            }
            if(is)
                continue;
            unSelectRoleList.add(new KeyValue(role1.getRoleName(), role1.getRoleId().toString()));
        }
        sysOperatorMessageVO.setRoleNameString(roleNameString.toString());
        sysOperatorMessageVO.setSelectRole(selectRoleList);
        sysOperatorMessageVO.setUnSelectRole(unSelectRoleList);
        return sysOperatorMessageVO;
    }

    @Override
    public List<KeyValue> searchOperators(SysOperatorMessageVO sysOperatorMessageVO) {
        List<SysRole> allRoleList = sysRoleMapper.getAllSysRole();
        List<KeyValue> selectAllRoleList = new ArrayList<>();
        if (allRoleList == null){
            return selectAllRoleList;
        }
        for(SysRole sysRole : allRoleList){
            if(sysRole != null && sysRole.getIsActive()!= null && TvmsTypes.ROLE_STATUS_IS_ACTIVED.intValue() == sysRole.getIsActive().intValue()){
                selectAllRoleList.add(new KeyValue(sysRole.getRoleName(), sysRole.getRoleId().toString()));
            }
        }

        return selectAllRoleList;
    }

    @Override
    public List<KeyValue> getAllRole() {
        List<SysRole> allRoleList = sysRoleMapper.getAllSysRole();
        List<KeyValue> selectAllRoleList = new ArrayList<>();
        if(allRoleList == null){
            return selectAllRoleList;
        }
        for(SysRole sysRole : allRoleList){
            if(sysRole != null && sysRole.getIsActive()!= null && TvmsTypes.ROLE_STATUS_IS_ACTIVED.intValue() == sysRole.getIsActive()){
                selectAllRoleList.add(new KeyValue(sysRole.getRoleName(), sysRole.getRoleId().toString()));
            }
        }

        return selectAllRoleList;
    }

    @Override
    public boolean updateOperatorRole(Long opId, String[] roleId) throws BusinessException {
        SysOperator sysOperator = sysOperatorMapper.getOperator(opId);
        List<SysRole> roleList = new ArrayList<>();
        if(roleId!=null && roleId.length > 0) {
            for(String rid : roleId){
                SysRole sysRole = sysRoleMapper.getSysRole(new Long(rid));
                roleList.add(sysRole);
            }
        }

        try {
            sysOperator.setSysRoles(roleList);
        } catch (BusinessException e) {
            throw new BusinessException("errors.sys.voucherStyle.saveExcep");
        }
        return sysOperatorMapper.updateOperator(sysOperator);
    }

    @Override
    public SysOperator getOperator(Long id) {
        return sysOperatorMapper.getOperator(id);
    }
}
