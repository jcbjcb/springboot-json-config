package com.jcb.spring.json.config.beanUtil.remote.config.build;

import java.util.Date;

public class TenLenTimeStamp {

    public static long getTenLenTimeStamp(){
        return  new Date().getTime()/1000;
    }
}
