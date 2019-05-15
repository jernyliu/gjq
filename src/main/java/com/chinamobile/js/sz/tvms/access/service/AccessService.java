package com.chinamobile.js.sz.tvms.access.service;

import com.chinamobile.js.sz.tvms.access.vo.LoginUserVO;

public interface AccessService {
    LoginUserVO processLogin(String operatorId, String password);

    void processLogout(Long operatorId);

    LoginUserVO checkLoginUser(String operatorId);
}
