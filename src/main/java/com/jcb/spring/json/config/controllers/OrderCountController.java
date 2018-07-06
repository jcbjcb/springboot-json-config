package com.jcb.spring.json.config.controllers;

import com.jcb.spring.json.config.service.L2Sh600OrderCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderCount")
public class OrderCountController {
    @Autowired
    private L2Sh600OrderCountService l2Sh600OrderCountService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/getOne")
    public Object getOne(){

        return l2Sh600OrderCountService.getOne();

    }

    @RequestMapping("/testRedis")
    public Object testRedis(){
        redisTemplate.opsForList().leftPush("testRedis","testRedis");
        return "redisTemplate";

    }

}
