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
     * @Description 保存String数据
     *
     * @param key 键值
     * @param value 值
     */
    void putString(String key, String value);

    /**
     * @Author www
     * @Date 2021/5/26 21:18
     * @Description 获取String数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    String getString(String key);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存Hash数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    void putHash(String key, String value);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取Hash数据
     *
     * @param key 键值
     * @return Object
     */
    Object getHash(String key);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存List数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    void putList(String key, String value);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取List数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    Object getList(String key);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存Set数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    void putSet(String key, String value);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取Set数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    Object getSet(String key);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 保存ZSet数据
     *
     * @param key 键值
     * @param value 值
     * @return void
     */
    void putZSet(String key, String value);
    /**
     * @Author www
     * @Date 2021/5/30 16:52
     * @Description 获取ZSet数据
     *
     * @param key 键值
     * @return java.lang.String
     */
    Object getZSet(String key);
}
