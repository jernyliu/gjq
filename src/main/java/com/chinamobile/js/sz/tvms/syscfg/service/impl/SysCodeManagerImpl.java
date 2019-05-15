package com.chinamobile.js.sz.tvms.syscfg.service.impl;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysCode;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysCodeMapper;
import com.chinamobile.js.sz.tvms.syscfg.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class SysCodeManagerImpl implements SysCodeService {

    @Autowired
    private SysCodeMapper sysCodeMapper;

    @Autowired
    private RedisTemplate<String, SysCode> redisTemplate;

    @Override
    public void initSysCodesCache() {
        List<SysCode> list = sysCodeMapper.listAllSysCodes();
        for(SysCode code: list) {
            redisTemplate.opsForValue().set(SysCode.buildHashKey(code.getCodeId(), code.getCodeValue()), code);
        }
    }

    @Override
    public SysCode getSysCode(String codeId, Long codeValue) {
        return redisTemplate.opsForValue().get(SysCode.buildHashKey(codeId, codeValue));
    }

    @Override
    public String getSysCodeDesc(String codeId, Long codeValue) {
        SysCode code =  redisTemplate.opsForValue().get(SysCode.buildHashKey(codeId, codeValue));
        return code != null ? code.getCodeDesc() : null;
    }

    @Override
    public List<SysCode> getSysCodes(String codeId) {
        Set<String> keys = redisTemplate.keys(codeId+"-*");
        Iterator<String> it = keys.iterator();
        List<SysCode> codes = new ArrayList<SysCode>();
        while(it.hasNext()) {
            codes.add(redisTemplate.opsForValue().get(it.next()));
        }
        return codes;
    }
}
