package com.chinamobile.js.sz.tvms.syscfg.service;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.utils.KeyValue;

import java.util.List;

public interface SysRoleService {

//    PaginationVO searchSysRoles(final PaginationVO paginationVO, final SysRole sysRole);
    List<SysRole> searchSysRoles(final SysRole sysRole);

    void removeSysRoles(String[] roleIdArr);

    void saveSysRole(SysRole sysRole, String[] sysFuncArr,String[] sysOperatorIdArr);

    SysRole getSysRoleByRoleId(Long roleId);

    List<SysOperator> searchSysOperators(String operatorName);

    List<KeyValue> getSysOperaterLblBeanList(List<SysOperator> sysOperatoerList);

    /**
     * check the system if has the same name sysRole
     * @param roleName
     * @param roleId
     * @return
     */
    boolean withSameNameSysRole(String roleName,Long roleId);
}
