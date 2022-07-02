package com.www.demo.dubbo.provider.service.impl;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
import com.www.demo.utils.MyBeanUtils;
import com.www.dubbo.model.SysUserInfo;
import com.www.dubbo.service.ISysUserInfoService;
import org.apache.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>@Description dubbo生产者服务 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:52 </p>
 */
@Service //注意是dubbo的Service
@Component //一般使用Component，避免与dubbo的Service重复
public class ProviderServiceImpl implements ISysUserInfoService {
    private static Logger LOG = LoggerFactory.getLogger(ProviderServiceImpl.class);
    @Autowired
    private ISysUserService sysUserService;
    /**
     * <p>@Description 根据用户Id查询用户信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:52 </p>
     * @param userId 用户Id
     * @return com.www.dubbo.model.SysUserInfo 用户信息
     */
    @Override
    public SysUserInfo findSysUserInfoById(String userId) {
        LOG.info("-----> dubbo服务被调用：userId = {}",userId);
        SysUserEntity sysUser = sysUserService.selectByUserId(userId);
        if(sysUser != null){
            SysUserInfo sysUserInfo = new SysUserInfo();
            MyBeanUtils.copyProperties(sysUser,sysUserInfo);
            return sysUserInfo;
        }
        return null;
    }
}
