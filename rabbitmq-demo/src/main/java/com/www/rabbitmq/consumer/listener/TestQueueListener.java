package com.www.rabbitmq.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * <p>@Description 通过代码配置队列与交换区关系的队列监听 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 22:53 </p>
 */
//@RabbitListener(queues = "test-queue")
@Service
public class TestQueueListener {
    private static Logger logger = LoggerFactory.getLogger(TestQueueListener.class);
    /**
     * <p>@Description 监听服务 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/26 22:27 </p>
     * @param msg
     * @return void
     */
//    @RabbitHandler
    public void reviceMsg(String msg){
        logger.info("-----> 通过代码配置队列与交换区关系的队列监听到的数据:{}",msg);
    }
}
