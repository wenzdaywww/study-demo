package com.www.demo.redis.controller;

import com.www.demo.model.entity.SysUserEntity;
import com.www.demo.redis.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
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
    /**
     * @Author www
     * @Date 2021/6/18 23:43
     * @Description 保存数据
     *
     * @param type 数据类型
     * @param key key值
     * @param value value值
     * @return java.lang.Object
     */
    @RequestMapping("/put/{type}/{key}/{value}")
    public @ResponseBody Object put(@PathVariable("type") String type,@PathVariable("key") String key,@PathVariable("value") String value){
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserId(key);
        userEntity.setUserName(value);
        if (StringUtils.equals(type,"str")){
            RedisUtil.set(key,userEntity);
        }else if (StringUtils.equals(type,"hash")){
            RedisUtil.hSet(key,userEntity);
        }else if (StringUtils.equals(type,"list")){
            RedisUtil.lSet(key,userEntity);
        }else if (StringUtils.equals(type,"set")){
            RedisUtil.sSet(key,userEntity);
        }else if (StringUtils.equals(type,"zset")){
            RedisUtil.zsSet(key,userEntity);
        }
        return value;
    }
    /**
     * @Author www
     * @Date 2021/6/18 23:43
     * @Description 获取数据
     *
     * @param type 数据类型
     * @param key key值
     * @return java.lang.Object
     */
    @RequestMapping("/get/{type}/{key}")
    public @ResponseBody Object get(@PathVariable("type") String type, @PathVariable("key") String key){
        if (StringUtils.equals(type,"hash")){
            return RedisUtil.hGet(key);
        }else if (StringUtils.equals(type,"list")){
            return RedisUtil.lGet(key);
        }else if (StringUtils.equals(type,"set")){
            return RedisUtil.sGet(key);
        }else if (StringUtils.equals(type,"zset")){
            return RedisUtil.zsGet(key);
        }else {
            return RedisUtil.get(key);
        }
    }
}
