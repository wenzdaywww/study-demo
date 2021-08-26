package com.www.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@Description rabbitmq配置类，主要配置队列与交换区关系，如果已在管理页面配置则不需要再配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/26 21:57 </p>
 */
@Configuration
public class TestQueueConfig {
    /**
     * <p>@Description 配置交换区 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 21:59 </p>
     * @return org.springframework.amqp.core.DirectExchange
     */
    @Bean
    public DirectExchange testDirect(){
        return new DirectExchange("test-direct",true,false);
    }
    /**
     * <p>@Description 配置队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 22:23 </p>
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue testQueue(){
        Map<String, Object> arguments = new HashMap<>();
        arguments.put("x-message-ttl",10000); //设置过期时间
        return new Queue("test-queue",true,false,false,arguments);
    }
    /**
     * <p>@Description 绑定交换区与队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 22:01 </p>
     *
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding testBinding(){
        return BindingBuilder.bind(testQueue()).to(testDirect()).with("test");
    }
}
