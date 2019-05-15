package com.chinamobile.js.sz.tvms.syscfg.pojo;

import java.io.Serializable;

public class SysOperatorRole implements Serializable {

	private Integer roleId;
	private Integer operatorId;

	protected Integer getRoleId() {
		return roleId;
	}

	protected void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	protected Integer getOperatorId() {
		return operatorId;
	}

	protected void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

}
