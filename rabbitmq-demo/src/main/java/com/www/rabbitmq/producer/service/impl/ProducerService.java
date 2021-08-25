package com.www.rabbitmq.producer.service.impl;

import com.www.rabbitmq.producer.service.IProducerService;
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
public class ProducerService implements IProducerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
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

    /**
     * <p>@Description 工作模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String work(String msg) {
        return null;
    }

    /**
     * <p>@Description 路由模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String direct(String msg) {
        return null;
    }

    /**
     * <p>@Description 发布订阅模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String fanout(String msg) {
        return null;
    }

    /**
     * <p>@Description 主题模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @Override
    public String topic(String msg) {
        return null;
    }
}
