package com.www.rabbitmq.consumer.service.impl;

import com.www.rabbitmq.consumer.service.IConsumerService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>@Description 生产者service </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 22:04 </p>
 */
@Service
public class ConsumerService implements IConsumerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    /**
     * <p>@Description 从消息队列获取消息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     *
     * @param type 消息模式类型
     * @return java.lang.String
     */
    @Override
    public String getMsg(String type) {
        String msg = null;
        if("simple".equals(type)){
            msg = (String) rabbitTemplate.receiveAndConvert("simple-queue");
        }
        return msg;
    }
}
