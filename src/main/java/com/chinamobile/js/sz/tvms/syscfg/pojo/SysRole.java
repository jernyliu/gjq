package com.chinamobile.js.sz.tvms.syscfg.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysRole implements Serializable {

    private Long roleId;
    private String  roleName;
    private String  roleDesc;
    private Integer isActive;

    private List<SysOperator> sysOperators = new ArrayList<>();
    private List<SysFunc> sysFuncs = new ArrayList<>();

    public List<SysOperator> getSysOperators() {
        return sysOperators;
    }

    public void setSysOperators(List<SysOperator> sysOperators) {
        this.sysOperators = sysOperators;
    }

    public List<SysFunc> getSysFuncs() {
        return sysFuncs;
    }

    public void setSysFuncs(List<SysFunc> sysFuncs) {
        this.sysFuncs = sysFuncs;
    }

    public Long getRoleId() {

        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer active) {
        isActive = active;
    }

    public SysRole() {
    }
}
