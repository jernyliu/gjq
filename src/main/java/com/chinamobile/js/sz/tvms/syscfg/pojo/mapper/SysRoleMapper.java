package com.chinamobile.js.sz.tvms.syscfg.pojo.mapper;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.utils.KeyValue;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper {
//    PaginationVO searchSysRoles(PaginationVO paginationVO, Map paraMap);
    List<SysRole> searchSysRoles(Map paraMap);

    SysRole getSysRole(Long roleId);

    void saveSysRole(SysRole sysRole);

    void removeSysRole(SysRole sysRole);

//    void updateSysRole(SysRole sysRole);

    List<SysRole> getAllSysRole();

//    void saveRoleFunc(SysRoleFunc sysRoleFunc);

    List<SysRole> getAllSysRoleByParam(KeyValue keyValue);


//    List<SysOperator> getSysOperatorsByRole(Long roleId);

//    List<SysRole> getSysOperatorsMobile(Long countyId, Long roleId);

//    Object[] getSysOperatorOrgInfo(Long operatorId);
}
