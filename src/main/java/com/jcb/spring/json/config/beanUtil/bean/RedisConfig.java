package com.jcb.spring.json.config.beanUtil.bean;

import java.util.Map;

public class RedisConfig {

    private int db;

    private String host;

    private int port;

    private String password;

    private Map<String,String>  channel =null;

    public int getDb() {
        return db;
    }

    public void setDb(int db) {
        this.db = db;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, String> getChannel() {
        return channel;
    }

    public void setChannel(Map<String, String> channel) {
        this.channel = channel;
    }
}
