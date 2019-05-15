package com.chinamobile.js.sz.tvms.syscfg.service.impl;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.common.exception.BusinessException;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRolePermission;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysOperatorMapper;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysOperatorRoleMapper;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysRoleMapper;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysRolePermissionMapper;
import com.chinamobile.js.sz.tvms.syscfg.service.SysRoleService;
import com.chinamobile.js.sz.tvms.utils.KeyValue;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysOperatorMapper sysOperatorMapper;

    @Autowired
    private SysOperatorRoleMapper sysOperatorRoleMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<SysRole> searchSysRoles(SysRole sysRole) {
        Map<String, Object> paraMap = new HashMap<>();
        paraMap.put("roleName", sysRole.getRoleName());
        paraMap.put("isActive",sysRole.getIsActive());

        if (StringUtil.isNotEmpty(sysRole.getRoleName())) {
            paraMap.put("roleName",  "%" + sysRole.getRoleName().trim() + "%");
        }

        return sysRoleMapper.searchSysRoles(paraMap);
    }

    @Override
    @Transactional
    public void removeSysRoles(String[] roleIdArr) {
        if (roleIdArr != null) {
            for (String roleId : roleIdArr) {
                SysRole sysRole = sysRoleMapper.getSysRole(Long.valueOf(roleId));
                sysRole.setSysOperators(null);
                sysRole.setIsActive(0);
                sysRoleMapper.removeSysRole(sysRole);
                sysOperatorRoleMapper.removeOperatorForRoleId(Long.valueOf(roleId));
            }
        }
    }

    @Override
    @Transactional
    public void saveSysRole(SysRole uiSysRole, String[] sysFuncArr, String[] sysOperatorIdArr) {
// save role
        List<SysRole> sysRoles = sysRoleMapper.getAllSysRoleByParam(new KeyValue("roleName", uiSysRole.getRoleName()));
        for(SysRole role : sysRoles){
            if(uiSysRole.getRoleId() == null || !uiSysRole.getRoleId().equals(role.getRoleId())) {
                throw new BusinessException("errors.roleName.isSame");
            }
        }
        SysRole sysRole = null;
        if (uiSysRole.getRoleId() != null) {
            sysRole = sysRoleMapper.getSysRole(uiSysRole.getRoleId());
        }
        if (sysRole == null) {
            sysRole = new SysRole();
        }
        sysRole.setRoleName(uiSysRole.getRoleName());
        sysRole.setRoleDesc(uiSysRole.getRoleDesc());
        sysRole.setIsActive(uiSysRole.getIsActive());

        if(sysOperatorIdArr != null && TvmsTypes.ROLE_STATUS_IS_ACTIVED.equals(uiSysRole.getIsActive())){
            List<SysOperator> sysOperatorList = new ArrayList<>();
            for (String operatorId : sysOperatorIdArr) {
                SysOperator sysOperator =  sysOperatorMapper.getOperator(new Long(operatorId));
                sysOperatorList.add(sysOperator);
            }
            sysRole.setSysOperators(sysOperatorList);
        }
        else{
            sysRole.setSysOperators(null);
        }

        sysRoleMapper.saveSysRole(sysRole);

        // save roleFuncs
        if(sysRole.getSysFuncs().size()!=0) {
            sysRolePermissionMapper.removeFuncByRoleId(sysRole.getRoleId());
        }
        if (sysFuncArr != null) {
            for (String s : sysFuncArr) {
                SysRolePermission sysRoleFunc = new SysRolePermission();
                sysRoleFunc.setRoleId(sysRole.getRoleId());
                sysRoleFunc.setFuncId(new Long(s));
                sysRolePermissionMapper.saveRoleFunc(sysRoleFunc);
            }
        }
    }

    @Override
    public SysRole getSysRoleByRoleId(Long roleId) {
        return sysRoleMapper.getSysRole(roleId);
    }

    @Override
    public List<SysOperator> searchSysOperators(String operatorName) {
        Map<String, Object> paraMap = new HashMap<>();
        if (StringUtil.isNotEmpty("operatorName")) {
            paraMap.put("operatorName",  "%" + operatorName.trim() + "%");
        }
        //search SysOperator
        List<SysOperator> objectList= sysOperatorMapper.searchSysOperators(paraMap);
        List<SysOperator> sysOperatorList  = new ArrayList<>();
        for (SysOperator ob : objectList) {
            SysOperator sysOperator = new SysOperator();
            sysOperator.setOperatorName(ob.getOperatorName()+"("+ob.getOperatorId()+")"+"("+ob.getSysOrg().getOrgName()+")");
            sysOperator.setOperatorId((Long)ob.getOperatorId());
            sysOperatorList.add(sysOperator)  ;
        }
        return sysOperatorList;
    }

    @Override
    public List<KeyValue> getSysOperaterLblBeanList(List<SysOperator> sysOperatorList) {
        List<KeyValue> operaterLblBeanList  = new ArrayList<>();
        if(sysOperatorList != null){
            for (SysOperator sysOperator : sysOperatorList) {
                StringBuffer operatorNameSB = new StringBuffer();
                operatorNameSB.append(sysOperator.getOperatorName())
                        .append("(")
                        .append(sysOperator.getOperatorId().toString())
                        .append(")").append("(").append(sysOperator.getSysOrg().getOrgName()).append(")");
                operaterLblBeanList.add(new KeyValue(operatorNameSB.toString(), sysOperator.getOperatorId().toString()));
            }
        }

        return  operaterLblBeanList;
    }

    @Override
    public boolean withSameNameSysRole(String roleName, Long roleId) {
        boolean hasSameName = false;
        List sysRoles = sysRoleMapper.getAllSysRoleByParam(new KeyValue("roleName",roleName));
        if(null == sysRoles || sysRoles.isEmpty())
            return false;
        for (Object sysRole : sysRoles) {
            if (null == roleId || !(roleId.equals(((SysRole) sysRole).getRoleId()))) {
                hasSameName = true;
            }
        }
        return hasSameName;
    }
}
