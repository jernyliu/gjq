package com.chinamobile.js.sz.tvms.syscfg.pojo.mapper;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;

import java.util.List;

public interface SysOperatorRoleMapper {
	
	List<SysOperator> getOperatorsByRoleId(Long roleId);
	
	List<SysRole> getRolesByOperatorId(Long operatorId);

	void removeOperatorForRoleId(Long roleId);
}
