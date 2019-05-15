package com.chinamobile.js.sz.tvms.syscfg.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SysFunc implements Serializable, Comparable<SysFunc> {

	private Long funcId;
	private Long parentFuncId;
	private Long orderIdx;
	private String name;
	private String url;

	private List<SysFunc> subFuncs;

	public Long getFuncId() {
		return funcId;
	}

	public void setFuncId(Long funcId) {
		this.funcId = funcId;
	}

	public Long getParentFuncId() {
		return parentFuncId;
	}

	public void setParentFuncId(Long parentFuncId) {
		this.parentFuncId = parentFuncId;
	}

	public Long getOrderIdx() {
		return orderIdx;
	}

	public void setOrderIdx(Long orderIdx) {
		this.orderIdx = orderIdx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<SysFunc> getSubFuncs() {
		return subFuncs;
	}

	public void setSubFuncs(List<SysFunc> subFuncs) {
		this.subFuncs = subFuncs;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysFunc sysFunc = (SysFunc) o;
        return Objects.equals(funcId, sysFunc.funcId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(funcId);
    }

    @Override
	public int compareTo(SysFunc o) {
		return this.orderIdx.compareTo(o.getOrderIdx());
	}
}
