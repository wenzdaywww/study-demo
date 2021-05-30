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
    public void putString(String key, String value){
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
    public String getString(String key){
        String value = (String)redisTemplate.opsForValue().get(key);
        return value;
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存Hash数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    @Override
    public void putHash(String key, String value){
        redisTemplate.opsForHash().put(key,key,value);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取Hash数据
     *
     * @param key 键值
     * @return Object
     */
    @Override
    public Object getHash(String key){
        return redisTemplate.opsForHash().get(key,key);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存List数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    @Override
    public void putList(String key, String value){
        redisTemplate.opsForList().rightPush(key,value);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取List数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    @Override
    public Object getList(String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存Set数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    @Override
    public void putSet(String key, String value){
        redisTemplate.opsForSet().add(key,value);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取Set数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    @Override
    public Object getSet(String key){
        return redisTemplate.opsForSet().pop(key);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存ZSet数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    @Override
    public void putZSet(String key, String value){
        redisTemplate.opsForZSet().add(key,value,-1);
    }
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取ZSet数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    @Override
    public Object getZSet(String key){
        return redisTemplate.opsForZSet().range(key,0,-1);
    }
}
