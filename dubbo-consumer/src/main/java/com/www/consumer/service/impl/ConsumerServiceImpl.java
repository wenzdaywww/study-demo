package com.www.consumer.service.impl;

import com.www.consumer.service.IConsumerService;
import com.www.dubbo.model.SysUserInfo;
import com.www.dubbo.service.ISysUserInfoService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * <p>@Description dubbo消费者服务 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:23 </p>
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
