package com.chinamobile.js.sz.tvms.syscfg.service;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysCode;

import java.util.List;

public interface SysCodeService {

    void initSysCodesCache();

    SysCode getSysCode(String codeId, Long codeValue);

    String getSysCodeDesc(String codeId, Long codeValue);

    List<SysCode> getSysCodes(String codeId);
}
