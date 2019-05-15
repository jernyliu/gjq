package com.chinamobile.js.sz.tvms.syscfg.vo;

import com.chinamobile.js.sz.tvms.utils.KeyValue;

import java.util.List;

public class SysOperatorMessageVO {
    private Long operatorId;

    private String shortNo;

    private String operatorName;

    private String contactTel;

    private String orgName;

    private Long countyId;

    private List<KeyValue> selectRole;

    private List<KeyValue> unSelectRole;

    private String[] selectRoleValue;

    private Long[] selectRoleValueLong;

    private String roleNameString ;

    private List roleName;

    private Long roleId;

    private Integer status;

    private Long orgId;

    private String oaName;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getShortNo() {
        return shortNo;
    }

    public void setShortNo(String shortNo) {
        this.shortNo = shortNo;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public List<KeyValue> getSelectRole() {
        return selectRole;
    }

    public void setSelectRole(List<KeyValue> selectRole) {
        this.selectRole = selectRole;
    }

    public List<KeyValue> getUnSelectRole() {
        return unSelectRole;
    }

    public void setUnSelectRole(List<KeyValue> unSelectRole) {
        this.unSelectRole = unSelectRole;
    }

    public String[] getSelectRoleValue() {
        return selectRoleValue;
    }

    public void setSelectRoleValue(String[] selectRoleValue) {
        this.selectRoleValue = selectRoleValue;
    }

    public Long[] getSelectRoleValueLong() {
        return selectRoleValueLong;
    }

    public void setSelectRoleValueLong(Long[] selectRoleValueLong) {
        this.selectRoleValueLong = selectRoleValueLong;
    }

    public String getRoleNameString() {
        return roleNameString;
    }

    public void setRoleNameString(String roleNameString) {
        this.roleNameString = roleNameString;
    }

    public List getRoleName() {
        return roleName;
    }

    public void setRoleName(List roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOaName() {
        return oaName;
    }

    public void setOaName(String oaName) {
        this.oaName = oaName;
    }
}
