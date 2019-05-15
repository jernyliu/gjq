package com.chinamobile.js.sz.tvms.access.vo;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysFunc;

import java.io.Serializable;
import java.util.List;

public class LoginUserVO implements Serializable {
    private Long operatorId;
    private Long loginSrl;
    private String operatorName;
    private Long orgId;
    private String orgName;
    private Long cityId;
    private String cityName;
    private boolean isSalesDept;
    private Long[] roleIds;
    private List<SysFunc> grantedFuncTree;

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getLoginSrl() {
        return loginSrl;
    }

    public void setLoginSrl(Long loginSrl) {
        this.loginSrl = loginSrl;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

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

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean isSalesDept() {
        return isSalesDept;
    }

    public void setSalesDept(boolean salesDept) {
        isSalesDept = salesDept;
    }

    public Long[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Long[] roleIds) {
        this.roleIds = roleIds;
    }

    public List<SysFunc> getGrantedFuncTree() {
        return grantedFuncTree;
    }

    public void setGrantedFuncTree(List<SysFunc> grantedFuncTree) {
        this.grantedFuncTree = grantedFuncTree;
    }
}
