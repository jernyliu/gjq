package com.chinamobile.js.sz.tvms.syscfg.pojo.mapper;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOrg;

import java.util.List;
import java.util.Map;

public interface SysOrgMapper {

    SysOrg getOrganization(Long id);

    SysOrg getSuperiorOrg(SysOrg superiorOrg);

    List<SysOrg> getLikeOrg(Map paraMap);

    List<SysOrg> getSubOrgsByName(Map paraMap);

    String getSysOrgNameById(Long orgId);
}
