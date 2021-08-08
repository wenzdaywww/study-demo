package com.www.consumer.service;

import com.www.dubbo.model.SysUserInfo;

/**
 * <p>@Description 消费者服务 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:23 </p>
 */
public interface IConsumerService {
    /**
     * <p>@Description 根据用户ID查询用户信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:24 </p>
     * @param userId 用户ID
     * @return com.www.dubbo.model.SysUserInfo
     */
    SysUserInfo findUserById(String userId);
}
