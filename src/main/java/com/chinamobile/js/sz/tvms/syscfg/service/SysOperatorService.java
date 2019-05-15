package com.chinamobile.js.sz.tvms.syscfg.service;

import com.chinamobile.js.sz.tvms.common.exception.BusinessException;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.vo.SysOperatorMessageVO;
import com.chinamobile.js.sz.tvms.utils.KeyValue;

import java.util.List;

public interface SysOperatorService {
    SysOperatorMessageVO getEditOperator(Long id);

//     PaginationVO searchOperators(final PaginationVO paginationVO, final SysOperatorMessageVO sysOperatorMessageVO);
    List<KeyValue> searchOperators(final SysOperatorMessageVO sysOperatorMessageVO);

    List<KeyValue> getAllRole();

    boolean updateOperatorRole(Long opId,String[] roleId) throws BusinessException;

    SysOperator getOperator(Long id);
}
