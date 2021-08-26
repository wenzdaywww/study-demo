package com.www.rabbitmq.producer.service.impl;

import com.www.rabbitmq.producer.service.IProducerService;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>@Description 生产者service </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 22:04 </p>
 */
@Service
public class ProducerServiceImpl implements IProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * <p>@Description 单个消息延时 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String ttl(String msg) {
        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setExpiration("5000"); //设置单个消息过期时间
                return message;
            }
        };
        rabbitTemplate.convertAndSend("ttl-direct","ttl",msg+ UUID.randomUUID(),messagePostProcessor);
        return msg;
    }
    /**
     * <p>@Description 通过代码配置队列与交换区关系的消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String test(String msg) {
        rabbitTemplate.convertAndSend("test-direct","test",msg+ UUID.randomUUID());
        return msg;
    }

    /**
     * <p>@Description 简单模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String simple(String msg) {
        for (int i = 0; i < 5; i++){
            rabbitTemplate.convertAndSend("my-simple","",msg+ UUID.randomUUID());
        }
        return msg;
    }
}
