package com.www.rabbitmq.consumer.service;

/**
 * <p>@Description 生产者service </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/25 22:04 </p>
 */
public interface IConsumerService {
    /**
     * <p>@Description 从消息队列获取消息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/25 21:46 </p>
     * @param type 消息模式类型
     * @return java.lang.String
     */
    String getMsg(String type);
}
