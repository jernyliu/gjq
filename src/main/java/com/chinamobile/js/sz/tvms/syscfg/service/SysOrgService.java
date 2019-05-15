package com.chinamobile.js.sz.tvms.syscfg.service;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOrg;

import java.util.List;

public interface SysOrgService {

    public SysOrg getSysOrg(Long id);

    public List<SysOrg> getLikeOrgName(String orgName, String countyId);

    Boolean isSellsDept(Long orgId);

    List<SysOrg> getSubOrgsByName(String orgName, Long orgId);
}
