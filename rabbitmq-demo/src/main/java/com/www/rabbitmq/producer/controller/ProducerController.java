package com.www.rabbitmq.producer.controller;

import com.www.rabbitmq.producer.service.IProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>@Description 生产者controller </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 21:42 </p>
 */
@RestController
@RequestMapping("/pro")
public class ProducerController {
    @Autowired
    private IProducerService producerService;

    /**
     * <p>@Description 简单模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("/simple/{msg}")
    public String simple(@PathVariable("msg") String msg){
        return producerService.simple(msg);
    }
    /**
     * <p>@Description 工作模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("/work/{msg}")
    public String work(@PathVariable("msg") String msg){
        return producerService.work(msg);
    }
    /**
     * <p>@Description 路由模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("/direct/{msg}")
    public String direct(@PathVariable("msg") String msg){
        return producerService.direct(msg);
    }
    /**
     * <p>@Description 发布订阅模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("/fanout/{msg}")
    public String fanout(@PathVariable("msg") String msg){
        return producerService.fanout(msg);
    }
    /**
     * <p>@Description 主题模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    @GetMapping("/topic/{msg}")
    public String topic(@PathVariable("msg") String msg){
        return producerService.topic(msg);
    }
}
