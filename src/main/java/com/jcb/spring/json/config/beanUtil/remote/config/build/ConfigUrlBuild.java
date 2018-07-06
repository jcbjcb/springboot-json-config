package com.jcb.spring.json.config.beanUtil.remote.config.build;

public class ConfigUrlBuild {

    public static String buildUrl(String url,String name,long timeStamp,String nonce,String signature){

        return url+="?name="+name+"&timestamp="+timeStamp+"&nonce="+nonce+"&signature="+signature;
    }
}
