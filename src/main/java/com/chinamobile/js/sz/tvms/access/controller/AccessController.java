package com.chinamobile.js.sz.tvms.access.controller;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.access.service.AccessService;
import com.chinamobile.js.sz.tvms.access.vo.LoginUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/gjq/")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("{page}")
    public String show(@PathVariable String page){
        return page;
    }

    @RequestMapping("login")
    public String login(String loginId, String loginPwd){
        LoginUserVO loginUserVO = accessService.processLogin(loginId, loginPwd);
        redisTemplate.opsForValue().set(TvmsTypes.LOGIN_USER, loginUserVO);
        return "home";
    }
}
