package com.chinamobile.js.sz.tvms.syscfg;

import com.chinamobile.js.sz.tvms.GjqApplication;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysOperatorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GjqApplication.class)
public class TestOperator {

    @Autowired
    private SysOperatorMapper sysOperatorMapper;

    @Test
    public void testgetOperator(){
        Map<String, Object> map = new HashMap<>();
        map.put("operatorName", "超级管理员");
        sysOperatorMapper.searchSysOperators(map);
//        SysOperator operator = sysOperatorMapper.getOperator(1111L);
    }
}
