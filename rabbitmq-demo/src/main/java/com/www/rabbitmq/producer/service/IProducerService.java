package com.www.rabbitmq.producer.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>@Description 生产者service </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 22:04 </p>
 */
public interface IProducerService {
    /**
     * <p>@Description 简单模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    String simple(String msg);
    /**
     * <p>@Description 工作模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    String work(String msg);
    /**
     * <p>@Description 路由模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    String direct(String msg);
    /**
     * <p>@Description 发布订阅模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    String fanout(String msg);
    /**
     * <p>@Description 主题模式发送消息到消息队列 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param msg
     * @return java.lang.String
     */
    String topic(String msg);
}
