package com.www.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>@Description rabbitmq配置类，死信队列配置 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/26 21:57 </p>
 */
@Configuration
public class DeadQueueConfig {
    /**
     * <p>@Description 配置交换区 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 21:59 </p>
     * @return org.springframework.amqp.core.DirectExchange
     */
    @Bean
    public DirectExchange deadDirect(){
        return new DirectExchange("dead-direct",true,false);
    }
    /**
     * <p>@Description 配置队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 22:23 </p>
     * @return org.springframework.amqp.core.Queue
     */
    @Bean
    public Queue deadQueue(){
        return new Queue("dead-queue",true,false,false);
    }
    /**
     * <p>@Description 绑定交换区与队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 22:01 </p>
     * @return org.springframework.amqp.core.Binding
     */
    @Bean
    public Binding deadBinding(){
        return BindingBuilder.bind(deadQueue()).to(deadDirect()).with("dead");
    }
}
