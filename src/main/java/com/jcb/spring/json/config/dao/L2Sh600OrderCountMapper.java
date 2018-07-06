package com.jcb.spring.json.config.dao;

import com.jcb.spring.json.config.daoUtil.MyBaseMapper;
import com.jcb.spring.json.config.pojo.L2Sh600OrderCount;
import org.apache.ibatis.annotations.Select;

public interface L2Sh600OrderCountMapper extends MyBaseMapper<L2Sh600OrderCount> {
    @Select("select * from l2_sh600_order_count limit 1")
    public L2Sh600OrderCount getOneLimti1();

}