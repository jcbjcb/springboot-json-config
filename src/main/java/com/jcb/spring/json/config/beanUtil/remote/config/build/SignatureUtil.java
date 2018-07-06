package com.jcb.spring.json.config.beanUtil.remote.config.build;

import com.jcb.spring.json.config.beanUtil.util.MD5Util;

public class SignatureUtil {

    public static String signtureUtil(long  timeStamp,String token,String nonce){
        return MD5Util.md5(timeStamp+token+nonce);
    }
}
