package com.www.rabbitmq.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * <p>@Description 简单模式的队列监听 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 22:53 </p>
 */
//@RabbitListener(queues = "simple-queue")
@Service
public class SimpleListener {
    private static Logger logger = LoggerFactory.getLogger(SimpleListener.class);

//    @RabbitHandler
    public void reviceMsg(String msg){
        logger.info("-----> 简单模式的队列监听到的数据:{}",msg);
    }
}
