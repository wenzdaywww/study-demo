package com.www.test;

import com.www.demo.model.entity.SysUserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author www
 * @version 1.0
 * @description
 * @date 2021/6/27 15:20
 */
@SpringBootTest
@SpringBootConfiguration
public class BootTest {
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test(){
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserId("www");
        redisTemplate.opsForValue().set("user",userEntity);
    }
}
