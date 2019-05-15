package com.chinamobile.js.sz.tvms.syscfg.pojo;


import java.io.Serializable;

public class SysOrg implements Serializable {

    private Long orgId;
    private String orgName;
    private Long superiorId;
    private Integer orgType;
    private String channelType;
    private Long countyId;
    private Long regionId;
    //	private Date createTime;
    //	private Date invalidTime;
    private Integer statusId;
//	private Long mobile;
//	private String address;
//	private String contactName;
//	private String contactTel;
//	private Long orgSubType;
//	private Long payfeeType;
//	private Long operator;
//	private Long czjfFlag;
//	private Integer starNum;
//	private Date signTime;
//	private String icNo;
//	private String bankName;
//	private String bankAccountId;
//	private String bankAccountName;
//	private String markMake;
//	private String doorSize;
//	private Integer oneOff;

    //	private Integer specialBusi;
    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getSuperiorId() {
        return superiorId;
    }

    public void setSuperiorId(Long superiorId) {
        this.superiorId = superiorId;
    }

    public Integer getOrgType() {
        return orgType;
    }

    public void setOrgType(Integer orgType) {
        this.orgType = orgType;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public SysOrg() {
    }
}
