package com.jcb.spring.json.config.daoUtil;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author jcb
 * @create 2018-06-20 12:08
 * @desc ${DESCRIPTION}
 **/
public interface MyBaseMapper<T> extends Mapper<T> ,MySqlMapper<T> {
}
