package com.example.www.dubbo.consumer.service.impl;

import com.example.www.dubbo.consumer.service.IConsumerService;
import com.www.dubbo.model.SysUserInfo;
import com.www.dubbo.service.ISysUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author www
 * @version 1.0
 * @description 消费者服务
 * @date 2021/7/5 22:45
 */
@Service
public class ConsumerServiceImpl implements IConsumerService {

    ISysUserInfoService sysUserInfoService;

    @Override
    public SysUserInfo findUserById(String userId) {
        return sysUserInfoService.findSysUserInfoById(userId);
    }
}
