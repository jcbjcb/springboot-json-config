package com.jcb.spring.json.config.beanUtil.remote.config.build;

import java.util.Map;

public class TokenBuild {


    public static String tokenBuild(){
        String token="abc";
        Map<String, String> map = System.getenv();
        if(map.get("token")!=null){
            token=map.get("token");
        }
        return token ;
    }
}
