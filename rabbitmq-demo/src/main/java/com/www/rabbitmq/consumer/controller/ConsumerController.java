package com.www.rabbitmq.consumer.controller;

import com.www.rabbitmq.consumer.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@Description 消费者controller </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 21:41 </p>
 */
@RestController
@RequestMapping("/con")
public class ConsumerController {
    @Autowired
    private IConsumerService consumerService;

    /**
     * <p>@Description 简单模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param type
     * @return java.lang.String
     */
    @GetMapping("/get/{type}")
    public String getMsg(@PathVariable("type") String type){
        return consumerService.getMsg(type);
    }
}
