package com.chinamobile.js.sz.tvms.access.controller;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.access.service.AccessService;
import com.chinamobile.js.sz.tvms.access.vo.LoginUserVO;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysFunc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/gjq/")
public class AccessController {

    @Autowired
    private AccessService accessService;

//    @RequestMapping("{page}")
//    public String show(@PathVariable String page){
//        return page;
//    }

    //传统的单体系统的mvc
   /* @RequestMapping("login")
    public String login(String loginId, String loginPwd, HttpServletRequest request, HttpServletResponse response){
        LoginUserVO loginUserVO = accessService.processLogin(loginId, loginPwd);
        redisTemplate.opsForValue().set(TvmsTypes.LOGIN_USER, loginUserVO);

        Cookie cookie = new Cookie("name", "jerny");
        responsdCookie(cookie);
        return "home";
    }*/

    // 前后端分离项目，使用cookie和session进行会话管理
    @PostMapping("login")
    public ResponseEntity<Void> login(String loginId, String loginPwd, HttpServletRequest request, HttpServletResponse response) {
        LoginUserVO loginUserVO = accessService.processLogin(loginId, loginPwd);
        HttpSession session = request.getSession();//JSESSIONID存入cookie
        session.setAttribute(TvmsTypes.LOGIN_USER, loginUserVO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<List<SysFunc>> getFuncList(HttpServletRequest request) {
        LoginUserVO loginUserVO = (LoginUserVO) request.getSession().getAttribute(TvmsTypes.LOGIN_USER);
        if (loginUserVO != null) {
            return ResponseEntity.ok().body(loginUserVO.getGrantedFuncTree());
        } else {
            // session过期了， 或者客户端cookie被删除
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    //前后端分离项目，使用jwt进行会话管理
    /*@Value("jwt.expired.munites")
    private String jwtExpired;
    @PostMapping("/login")
    public ResponseEntity<String> login(String loginId, String loginPwd){
        SysOperator operator = accessService.authenticate(loginId, loginPwd);
        if(operator == null) {
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        JWTSubject subject = new JWTSubject(operator.getOperatorId(), operator.getOperatorName());
        String token = JWTUtils.createJWT(UUID.randomUUID().toString(), "gjq_jerny", JWTUtils.generateSubject(subject), Long.valueOf(jwtExpired));
        return ResponseEntity.ok(token);
    }*/

}
