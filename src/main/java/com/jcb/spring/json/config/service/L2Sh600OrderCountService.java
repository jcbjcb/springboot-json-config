package com.jcb.spring.json.config.service;

import com.jcb.spring.json.config.dao.L2Sh600OrderCountMapper;
import com.jcb.spring.json.config.pojo.L2Sh600OrderCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class L2Sh600OrderCountService {

    @Autowired
    private L2Sh600OrderCountMapper l2Sh600OrderCountMapper;

    public L2Sh600OrderCount getOne(){
        return l2Sh600OrderCountMapper.getOneLimti1();

    }
}
