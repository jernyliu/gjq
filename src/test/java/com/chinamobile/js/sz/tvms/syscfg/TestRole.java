package com.chinamobile.js.sz.tvms.syscfg;

import com.chinamobile.js.sz.tvms.GjqApplication;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysRole;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysRoleMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GjqApplication.class)
public class TestRole {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void test(){
        SysRole sysRole = sysRoleMapper.getSysRole(1L);
        System.out.println(sysRole);
    }
}
