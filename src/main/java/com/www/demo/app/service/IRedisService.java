package com.www.demo.app.service;

/**
 * @version 1.0
 * @Description
 * @Author www
 * @Date 2021/5/26 21:16
 */
public interface IRedisService {
    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 保存数据
     *
     * @param key 键值
     * @param value 值
     */
    void put(String key,String value);

    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 获取数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    String get(String key);
}
