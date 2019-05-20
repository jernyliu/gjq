package com.chinamobile.js.sz.tvms.access.service;

import com.chinamobile.js.sz.tvms.access.vo.LoginUserVO;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;

public interface AccessService {
    LoginUserVO processLogin(String operatorId, String password);

    SysOperator authenticate(String operatorId, String password);

    void processLogout(Long operatorId);

    LoginUserVO checkLoginUser(String operatorId);
}
