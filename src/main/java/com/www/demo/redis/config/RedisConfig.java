package com.www.demo.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author www
 * @version 1.0
 * @description redis配置类
 * @date 2021/6/27 15:15
 */
@Configuration
public class RedisConfig {
    /**
     * @author www
     * @date 2021/6/27 15:31
     * @description 自定义redisTemplate
     * @param redisConnectionFactory redis连接工厂
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.Sring, java.lang.Object>
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        //json序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper obj = new ObjectMapper();
        obj.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        obj.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(obj);
        //String序列化配置
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key采用string 序列化
        template.setKeySerializer(stringRedisSerializer);
        //hash的key用string 序列化
        template.setHashKeySerializer(stringRedisSerializer);
        //value采用jackson序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
