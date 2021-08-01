package com.www.dubbo.service;

import com.www.dubbo.model.SysUserInfo;

/**
 * <p>@Description 用户信息接口 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:25 </p>
 */
public interface ISysUserInfoService {
    /**
     * <p>@Description 根据用户Id查询用户信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:25 </p>
     * @param userId 用户Id
     * @return com.www.dubbo.model.SysUserInfo
     */
    SysUserInfo findSysUserInfoById(String userId);
}
