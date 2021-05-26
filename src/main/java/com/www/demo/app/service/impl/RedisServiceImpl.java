package com.www.demo.app.service.impl;

import com.www.demo.app.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Description
 * @Author www
 * @Date 2021/5/26 21:16
 */
@Service
public class RedisServiceImpl implements IRedisService {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 保存数据
     *
     * @param key 键值
     * @param value 值
     */
    @Override
    public void put(String key,String value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 获取数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    @Override
    public String get(String key){
        String value = (String)redisTemplate.opsForValue().get(key);
        return value;
    }
}
