package com.www.dubbo.service;

import com.www.dubbo.model.SysUserInfo;

/**
 * @author www
 * @version 1.0
 * @description 用户信息接口
 * @date 2021/7/24 09:38
 */
public interface ISysUserInfoService {
    /**
     * @author www
     * @date 2021/7/24 09:39
     * @description 根据用户Id查询用户信息
     * @param userId 用户Id
     * @return com.www.model.dubbo.SysUserInfo
     */
    SysUserInfo findSysUserInfoById(String userId);
}
