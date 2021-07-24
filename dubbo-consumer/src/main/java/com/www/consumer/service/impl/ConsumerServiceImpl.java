package com.www.consumer.service.impl;

import com.www.consumer.service.IConsumerService;
import com.www.dubbo.model.SysUserInfo;
import com.www.dubbo.service.ISysUserInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @author www
 * @version 1.0
 * @description 消费者服务
 * @date 2021/7/5 22:45
 */
@Service
public class ConsumerServiceImpl implements IConsumerService {
    @Reference
    private ISysUserInfoService sysUserInfoService;

    @Override
    public SysUserInfo findUserById(String userId) {
        return sysUserInfoService.findSysUserInfoById(userId);
    }
}
