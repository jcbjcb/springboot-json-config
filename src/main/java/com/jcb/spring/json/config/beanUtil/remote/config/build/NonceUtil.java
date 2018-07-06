package com.jcb.spring.json.config.beanUtil.remote.config.build;

public class NonceUtil {

    public static  String getNonce(){
        return (Math.random()*1000000+"").substring(0,6);
    }
}
