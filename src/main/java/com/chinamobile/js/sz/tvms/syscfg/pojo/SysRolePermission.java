package com.chinamobile.js.sz.tvms.syscfg.pojo;

import java.io.Serializable;

public class SysRolePermission implements Serializable {
    private Long roleId;
    private Long funcId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getFuncId() {
        return funcId;
    }

    public void setFuncId(Long funcId) {
        this.funcId = funcId;
    }

    public SysRolePermission() {
    }
}
