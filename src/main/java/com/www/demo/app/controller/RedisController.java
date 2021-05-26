package com.www.demo.app.controller;

import com.www.demo.app.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @Description redis框架测试控制层
 * @Author www
 * @Date 2021/5/25 23:02
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private IRedisService redisService;

    @RequestMapping("/put/{key}/{value}")
    public @ResponseBody Object put(@PathVariable("key") String key,@PathVariable("value") String value){
        redisService.put(key,value);
        return value;
    }

    @RequestMapping("/get/{key}")
    public @ResponseBody Object get(@PathVariable("key") String key){
        return redisService.get(key);
    }
}
