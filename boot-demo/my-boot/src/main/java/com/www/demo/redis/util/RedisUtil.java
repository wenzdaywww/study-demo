package com.www.demo.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>@Description redis工具类 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:07 </p>
 */
@Component
public final class RedisUtil {
    private static RedisTemplate<String,Object> redisTemplate;
    /**
     * <p>@Description 返回redisTemplate实例 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:07 </p>
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String, java.lang.Object>
     */
    public static RedisTemplate<String,Object> getRedisTemplate(){
        return redisTemplate;
    }
    /**
     * <p>@Description 判断key值是否存在 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:07 </p>
     * @param key 键值
     * @return boolean
     */
    public static boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }
    /**
     * <p>@Description 保存String数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:07 </p>
     * @param key 键值
     * @param value 值
     * @return java.lang.Object
     */
    public static Object set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
        return value;
    }
    /**
     * <p>@Description 获取String数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:07 </p>
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object get(String key){
        Object value = redisTemplate.opsForValue().get(key);
        return value;
    }
    /**
     * <p>@Description 保存Hash数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:08 </p>
     * @param key 键值
     * @param okey 对象键值
     * @param value 值
     * @return java.lang.Object
     */
    public static Object hashSet(String key, String okey, Object value){
        redisTemplate.opsForHash().put(key,okey,value);
        return value;
    }
    /**
     * <p>@Description 获取存储在哈希表中指定字段的值 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:08 </p>
     * @param key 键值
     * @param okey 对象字段
     * @return java.lang.Object
     */
    public static Object hashGet(String key, String okey){
        return redisTemplate.opsForHash().get(key,okey);
    }
    /**
     * <p>@Description 获取在哈希表中指定 key 的所有字段和值 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:08 </p>
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object hashGet(String key){
        return redisTemplate.opsForHash().values(key);
    }
    /**
     * <p>@Description 从左边保存List数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:08 </p>
     * @param key 键值
     * @param value 值
     * @return java.lang.Object
     */
    public static Object listSet(String key, Object value){
        redisTemplate.opsForList().leftPush(key,value);
        return value;
    }
    /**
     * <p>@Description 获取List集合中所有数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:09 </p>
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object listGet(String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }
    /**
     * <p>@Description 保存Set数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:09 </p>
     * @param key 键值
     * @param value 值
     * @return java.lang.Object
     */
    public static Object setSet(String key, Object value){
       redisTemplate.opsForSet().add(key,value);
        return value;
    }
    /**
     * <p>@Description 返回Set集合中的所有数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:09 </p>
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object setGet(String key){
        return redisTemplate.opsForSet().members(key);
    }
    /**
     * <p>@Description 保存ZSet数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:09 </p>
     * @param key 键值
     * @param value 值
     * @param score 分值
     * @return java.lang.Object
     */
    public static Object zsetSet(String key, Object value, double score){
        redisTemplate.opsForZSet().add(key,value,score);
        return value;
    }
    /**
     * <p>@Description 获取ZSet数据 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:09 </p>
     * @param key 键值
     * @return java.lang.Object
     */
    public static Object zsetGet(String key){
        return redisTemplate.opsForZSet().range(key,0,-1);
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil.redisTemplate = redisTemplate;
    }
}
