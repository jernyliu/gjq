package com.chinamobile.js.sz.tvms.util;

import com.chinamobile.js.sz.tvms.GjqApplication;
import com.chinamobile.js.sz.tvms.utils.SystemUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GjqApplication.class)
public class TestSystemUtil {
    @Autowired
    private SystemUtil systemUtil;

    @Test
    public void test(){
        String msg = systemUtil.getProperty("org.type.market.num");
        System.out.println(msg);
    }
}
