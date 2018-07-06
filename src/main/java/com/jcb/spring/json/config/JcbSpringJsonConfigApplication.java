package com.jcb.spring.json.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JcbSpringJsonConfigApplication {

    public static void main(String[] args) {
//        System.out.println("args = [" + args.length + "]");
//        String[] argss=new String[]{"-c","G:\\work\\ideawork\\jcb-spring-json-config\\src\\main\\resources\\config.json"};
        SpringApplication.run(JcbSpringJsonConfigApplication.class, args);
    }
}
