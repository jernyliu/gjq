package com.chinamobile.js.sz.tvms.syscfg.service.impl;

import com.chinamobile.js.sz.tvms.syscfg.pojo.SysFunc;
import com.chinamobile.js.sz.tvms.syscfg.pojo.mapper.SysFuncMapper;
import com.chinamobile.js.sz.tvms.syscfg.service.SysFuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysFuncServiceImpl implements SysFuncService {

    private static List<SysFunc> sysFuncTree = null;

    @Autowired
    private SysFuncMapper sysFuncMapper;

    @Override
    public synchronized List<SysFunc> getSysFuncTree() {
        if (sysFuncTree == null) {
            sysFuncTree = sysFuncMapper.getSysFuncTree();
        }
        return sysFuncTree;
    }

    @Override
    public String getSysFuncName(Long funcId) {
        SysFunc sysFunc = getSysFunc(funcId);
        if (sysFunc != null) {
            return sysFunc.getName();
        }
        return null;
    }

    @Override
    public String getSysFuncParentName(Long funcId) {
        SysFunc sysFunc = getParentSysFunc(funcId);
        if (sysFunc != null) {
            return sysFunc.getName();
        }
        return null;
    }

    @Override
    public List<SysFunc> buildRoleSysFuncTree(Set<Long> sysFuncIds) {
        // build map
        Map<SysFunc, List<SysFunc>> parentMap = new HashMap<>();
        if (sysFuncIds != null) {
            for (Long funcId : sysFuncIds) {
                SysFunc sysFunc = getSysFunc(funcId);
                SysFunc parentSysFunc = copyParentSysFunc(funcId);
                if (parentSysFunc != null) {
                    if (parentMap.containsKey(parentSysFunc)) {
                        List<SysFunc> subList = parentMap.get(parentSysFunc);
                        if (!subList.contains(sysFunc)) {
                            subList.add(sysFunc);
                        }
                    } else {
                        List<SysFunc> subList = new ArrayList<>();
                        subList.add(sysFunc);
                        parentMap.put(parentSysFunc, subList);
                    }
                }
            }
        }

        // build parent list with sorting
        List<SysFunc> parentList = new ArrayList<>();
        for (SysFunc parentSysFunc : parentMap.keySet()) {
            List<SysFunc> subList = parentMap.get(parentSysFunc);

            Collections.sort(subList);
            parentSysFunc.setSubFuncs(subList);

            parentList.add(parentSysFunc);
        }
        Collections.sort(parentList);
        return parentList;
    }

    private SysFunc getSysFunc(Long funcId) {
        if (getSysFuncTree() != null) {
            for (SysFunc sysFunc : sysFuncTree) {
                if (funcId.equals(sysFunc.getFuncId())) {
                    return sysFunc;
                }

                List<SysFunc> subFuncs = sysFunc.getSubFuncs();
                if (subFuncs != null) {
                    for (SysFunc subSysFunc : subFuncs) {
                        if (funcId.equals(subSysFunc.getFuncId())) {
                            return subSysFunc;
                        }
                    }
                }
            }
        }
        return null;
    }

    private SysFunc getParentSysFunc(Long funcId) {
        SysFunc sysFunc = getSysFunc(funcId);
        if (sysFunc != null) {
            SysFunc parentSysFunc = getSysFunc(sysFunc.getParentFuncId());
            if (parentSysFunc != null) {
                return parentSysFunc;
            }
        }
        return null;
    }

    private SysFunc copyParentSysFunc(Long funcId) {
        SysFunc parentFunc = getParentSysFunc(funcId);
        if (parentFunc == null) {
            return null;
        }
        SysFunc newParentFunc = new SysFunc();
        newParentFunc.setFuncId(parentFunc.getFuncId());
        newParentFunc.setParentFuncId(parentFunc.getParentFuncId());
        newParentFunc.setName(parentFunc.getName());
        newParentFunc.setUrl(parentFunc.getUrl());
        newParentFunc.setOrderIdx(parentFunc.getOrderIdx());
        return newParentFunc;
    }
}
