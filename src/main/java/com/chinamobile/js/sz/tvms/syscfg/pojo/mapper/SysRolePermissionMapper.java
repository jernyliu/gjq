package com.chinamobile.js.sz.tvms.syscfg.pojo.mapper;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysFunc;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRolePermission;

import java.util.List;

public interface SysRolePermissionMapper {
    List<SysFunc> getSysFuncByRoleId(Long roleId);

    void removeFuncByRoleId(Long roleId);

    void saveRoleFunc(SysRolePermission sysRoleFunc);
}
