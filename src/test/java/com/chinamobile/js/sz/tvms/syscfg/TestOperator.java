package com.chinamobile.js.sz.tvms.syscfg;

import com.chinamobile.js.sz.tvms.GjqApplication;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysOperator;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysOperatorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GjqApplication.class)
public class TestOperator {

    @Autowired
    private SysOperatorMapper sysOperatorMapper;

    @Test
    public void testGetOperator(){
        SysOperator operator = sysOperatorMapper.getOperator(1111L);
        System.out.println(operator);
    }
}
