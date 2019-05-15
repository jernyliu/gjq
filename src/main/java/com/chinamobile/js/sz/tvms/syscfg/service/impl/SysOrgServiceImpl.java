package com.chinamobile.js.sz.tvms.syscfg.service.impl;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOrg;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysOrgMapper;
import com.chinamobile.js.sz.tvms.syscfg.service.SysOrgService;
import com.chinamobile.js.sz.tvms.utils.SystemUtil;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysOrgServiceImpl implements SysOrgService {

    @Autowired
    private SysOrgMapper sysOrgMapper;

    @Autowired
    private SystemUtil systemUtil;

    @Override
    public SysOrg getSysOrg(Long id) {
        return sysOrgMapper.getOrganization(id);
    }

    @Override
    public List<SysOrg> getLikeOrgName(String orgName, String countyId) {
        Map<String, Object> paraMap = new HashMap<>();
        if((StringUtil.isNotEmpty(countyId)) && (!(TvmsTypes.CITY_SZ).equals(new Long(countyId)))){
            Long countyIdLong = new Long(countyId);
            paraMap.put("countyId", countyIdLong);
        }
        if (StringUtil.isNotEmpty(orgName)){
            String value ="%" + orgName.trim() + "%";
            paraMap.put("orgName", value);
        }
        String[] ballArr = systemUtil.getProperty("org.type.market.num").split(",");
        List<Integer> orgTypes = new ArrayList<>();
        for(String s : ballArr) {
            orgTypes.add(Integer.valueOf(s));
        }
        paraMap.put("orgTypes", orgTypes);
        return sysOrgMapper.getLikeOrg(paraMap);
    }

    @Override
    public Boolean isSellsDept(Long orgId) {
        if (orgId != null && orgId >= 0L) {
            SysOrg sysOrg = getSysOrg(orgId);
            if(null != sysOrg) {
                Integer orgType = sysOrg.getOrgType();
                String[] ballArr = systemUtil.getProperty("org.type.market.num").split(",");
                for(String s : ballArr) {
                    if(orgType.toString().equals(s)) {
                        return Boolean.TRUE;
                    }
                }
            }
        }
        return Boolean.FALSE;
    }

    @Override
    public List<SysOrg> getSubOrgsByName(String orgName, Long cityId) {
        List<SysOrg> retList;
        Map<String, Object> paraMap = new HashMap<>();
        if (StringUtil.isNotEmpty(orgName)){
            String value ="%" + orgName.trim() + "%";
            paraMap.put("orgName", value);
        }
        if (cityId != null && !(cityId.equals(TvmsTypes.CITY_SZ))) {
            paraMap.put("cityId", cityId);
        }

        String[] ballArr = systemUtil.getProperty("org.type.market.num").split(",");
        List<Integer> orgTypes = new ArrayList<>();
        for(String s : ballArr) {
            orgTypes.add(Integer.valueOf(s));
        }
        paraMap.put("orgTypes", orgTypes);
        retList = sysOrgMapper.getSubOrgsByName(paraMap);
        return retList;
    }
}
