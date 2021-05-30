package com.www.demo.app.controller;

import com.www.demo.app.service.IRedisService;
import org.apache.commons.lang3.StringUtils;
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

    @RequestMapping("/put/{type}/{key}/{value}")
    public @ResponseBody Object put(@PathVariable("type") String type,@PathVariable("key") String key,@PathVariable("value") String value){
        if (StringUtils.equals(type,"str")){
            redisService.putString(key,value);
        }else if (StringUtils.equals(type,"hash")){
            redisService.putHash(key,value);
        }else if (StringUtils.equals(type,"list")){
            redisService.putList(key,value);
        }else if (StringUtils.equals(type,"set")){
            redisService.putSet(key,value);
        }else if (StringUtils.equals(type,"zset")){
            redisService.putZSet(key,value);
        }
        return value;
    }

    @RequestMapping("/get/{type}/{key}")
    public @ResponseBody Object get(@PathVariable("type") String type, @PathVariable("key") String key){
        if (StringUtils.equals(type,"hash")){
            return redisService.getHash(key);
        }else if (StringUtils.equals(type,"list")){
            return redisService.getList(key);
        }else if (StringUtils.equals(type,"set")){
            return redisService.getSet(key);
        }else if (StringUtils.equals(type,"zset")){
            return redisService.getZSet(key);
        }else {
            return redisService.getString(key);
        }
    }
}
