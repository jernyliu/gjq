package com.chinamobile.js.sz.tvms.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SystemUtil {

    @Autowired
    private Environment environment;

    public String getProperty(String msg) {
        return environment.getProperty(msg);
    }

    public String getString(String msg, String defaultValue) {
        msg = environment.getProperty(msg);
        return  msg != null ? msg : defaultValue;
    }

    public int getInt(String msg, int defaultValue){
        msg = environment.getProperty(msg);
        return msg != null ? Integer.valueOf(msg) : defaultValue;
    }
}
