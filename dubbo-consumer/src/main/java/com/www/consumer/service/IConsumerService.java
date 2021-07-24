package com.www.consumer.service;

import com.www.dubbo.model.SysUserInfo;

/**
 * @author www
 * @version 1.0
 * @description
 * @date 2021/7/5 22:45
 */
public interface IConsumerService {
    /**
     * @author www
     * @date 2021/7/24 09:56
     * @description 根据用户ID查询用户信息
     * @param userId 用户ID
     * @return com.www.model.dubbo.SysUserInfo
     */
    SysUserInfo findUserById(String userId);
}
