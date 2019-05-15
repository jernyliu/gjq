package com.chinamobile.js.sz.tvms.syscfg.controller;

import com.chinamobile.js.sz.tvms.TvmsTypes;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.syscfg.service.SysRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/syscfg/")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("initSearchSysRoles")
    public String initSearchSysRoles(HttpSession session, SysRole sysRole, Model model, int pageNum, int pageSize){
        session.setAttribute(TvmsTypes.LOGIN_USER_FUNC, TvmsTypes.FUNC_SYSCFG_ROLE);
        sysRole.setIsActive(TvmsTypes.IS_ACTIVE);
        model.addAttribute("roleIdArr",new String[0]);

        PageHelper.startPage(pageNum, pageSize);
        List<SysRole> sysRoles = sysRoleService.searchSysRoles(sysRole);
        model.addAttribute("pagination", sysRoles);
        return "SearchSysRoles";
    }
}
