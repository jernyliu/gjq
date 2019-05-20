package com.chinamobile.js.sz.tvms.common.jwt;

/**
 * 作为Subject数据使用。也就是payload中保存的public claims
 * 其中不包含任何敏感数据
 * 开发中建议使用实体类型。或BO，DTO数据对象。
 */
public class JWTSubject {

	private Long operatorId;
	private String operatorName;

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public JWTSubject() {
	}

	public JWTSubject(Long operatorId, String operatorName) {
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}
}
