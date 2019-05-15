package com.chinamobile.js.sz.tvms.syscfg.pojo;

import java.io.Serializable;
import java.util.Objects;

public class SysCode implements Serializable {

	private String codeId;
	
	private Long codeValue;
	
	private String codeDesc;

    public String getCodeId() {
        if (codeId != null) {
            return codeId.toUpperCase();
        }
        return null;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId.toUpperCase();
    }

    public Long getCodeValue() {
		return codeValue;
	}

	public void setCodeValue(Long codeValue) {
		this.codeValue = codeValue;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

    public static String buildHashKey(String codeId, Long codeValue) {
        return codeId +"-"+ codeValue.longValue();
    }

	public SysCode() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysCode sysCode = (SysCode) o;
		return Objects.equals(codeId, sysCode.codeId) &&
				Objects.equals(codeValue, sysCode.codeValue);
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeId, codeValue);
	}
}
