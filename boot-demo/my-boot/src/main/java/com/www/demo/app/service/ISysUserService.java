package com.www.demo.app.service;

import com.www.demo.model.dto.SysUserDTO;
import com.www.demo.model.entity.SysUser;

import java.util.List;

/**
 * <p>@Description 用户信息服务接口 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/5/20 23:14 </p>
 */
public interface ISysUserService {
    /**
     * <p>@Description 查询用户信息，包含角色信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:30 </p>
     * @param userId 用户id
     * @return com.www.demo.model.dto.SysUserDTO
     */
    SysUserDTO findUserAllInfo(String userId);
    /**
     * <p>@Description 查询用户信息 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:30 </p>
     * @param page 当前页数
     * @param user 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUser>
     */
    List<SysUser> findUserList(int page,SysUser user);
    /**
     * <p>@Description 根据用户ID查询用户信息</p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:30 </p>
     * @param userId 用户ID
     * @return com.www.demo.model.entity.SysUser 用户信息
     */
    SysUser selectByUserId(String userId);
    /**
     * <p>@Description 插入用户信息（更新非空数据） </p>
     * <p>@Author www </p>
     * <p>@Date . 21:31 </p>
     * @param record 用户信息
     * @return int 插入条数
     */
    int insertSelective(SysUser record);
    /**
     * <p>@Description 根据主键更新用户信息（更新非空数据） </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 21:31 </p>
     * @param record 用户信息
     * @return int 插入条数
     */
    int updateByUserId(SysUser record);
}