package com.www.demo.dubbo.provider.service.impl;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import com.www.demo.utils.MyBeanUtils;
import com.www.dubbo.model.SysUserInfo;
import com.www.dubbo.service.ISysUserInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author www
 * @version 1.0
 * @description 生产者服务
 * @date 2021/7/5 22:45
 */
@Service
@Component
public class ProviderServiceImpl implements ISysUserInfoService {
    private static Logger LOG = LoggerFactory.getLogger(ProviderServiceImpl.class);
    @Autowired
    private ISysUserService sysUserService;
    /**
     * @author www
     * @date 2021/7/24 09:39
     * @description 根据用户Id查询用户信息
     * @param userId 用户Id
     * @return com.www.model.dubbo.SysUserInfo
     */
    @Override
    public SysUserInfo findSysUserInfoById(String userId) {
        LOG.info("-----> dubbo服务被调用：userId = {}",userId);
        SysUser sysUser = sysUserService.selectByUserId(userId);
        if(sysUser != null){
            SysUserInfo sysUserInfo = new SysUserInfo();
            MyBeanUtils.copyProperties(sysUser,sysUserInfo);
            return sysUserInfo;
        }
        return null;
    }
}
