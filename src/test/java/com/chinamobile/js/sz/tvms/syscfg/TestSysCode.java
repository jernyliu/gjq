package com.chinamobile.js.sz.tvms.syscfg;

import com.chinamobile.js.sz.tvms.GjqApplication;
import com.chinamobile.js.sz.tvms.syscfg.pojo.SysCode;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysCodeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GjqApplication.class)
public class TestSysCode {
    @Autowired
    private SysCodeMapper sysCodeMapper;

    @Test
    public void test(){
        List<SysCode> list =  sysCodeMapper.listAllSysCodes();
    }
}
