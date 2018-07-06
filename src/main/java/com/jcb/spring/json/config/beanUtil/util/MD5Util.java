package com.jcb.spring.json.config.beanUtil.util;

import java.security.MessageDigest;

public class MD5Util {

    public static String md5(String source) {

        StringBuilder sb = new StringBuilder(32);

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] array = md.digest(source.getBytes("utf-8"));

            for (byte anArray : array) {
                sb.append(Integer.toHexString((anArray & 0xFF) | 0x100).toLowerCase(), 1, 3);
            }
        } catch (Exception e) {
            return null;
        }

        return sb.toString();
    }
}
