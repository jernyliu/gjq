package com.chinamobile.js.sz.tvms.syscfg.pojo.mapper;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;

import java.util.List;
import java.util.Map;

public interface SysOperatorMapper {
//    void save(SysOperator sysOperator);

    boolean updateOperator(SysOperator sysOperator);

    SysOperator getOperator(Long id);

//    PaginationVO searchOperators(PaginationVO paginationVO, Map paraMap);
    List<SysOperator> searchOperators(Map paraMap);

    List<SysOperator> searchSysOperators(Map paraMap);
}
