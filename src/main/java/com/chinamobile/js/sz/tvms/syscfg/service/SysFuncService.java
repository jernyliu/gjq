package com.chinamobile.js.sz.tvms.syscfg.service;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysFunc;

import java.util.List;
import java.util.Set;

public interface SysFuncService {
    List<SysFunc> getSysFuncTree();

    String getSysFuncName(Long funcId);

    String getSysFuncParentName(Long funcId);

    List<SysFunc> buildRoleSysFuncTree(Set<Long> sysRoleFunc);
}
