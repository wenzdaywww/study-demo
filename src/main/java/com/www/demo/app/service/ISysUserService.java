package com.www.demo.app.service;

import com.www.demo.model.entity.SysUserEntity;

import java.util.List;

/**
 * @version 1.0
 * @Description 用户信息服务接口
 * @Author www
 * @Date 2021/5/20 23:14
 */
public interface ISysUserService {
    /**
     * @Author www
     * @Date 2021/6/15 23:15
     * @Description 查询用户信息，包含角色信息
     *
     * @param userId 用户id
     * @return com.www.demo.model.entity.SysUserEntity
     */
    SysUserEntity findUserAllInfo(String userId);
    /**
     * @Author www
     * @Date 2021/6/15 23:15
     * @Description 查询用户信息，包含角色信息
     *
     * @param reqUser 查询条件
     * @return com.www.demo.model.entity.SysUserEntity
     */
    SysUserEntity findUserAllInfo(SysUserEntity reqUser);
    /**
     * @Author www
     * @Date 2021/6/7 22:56
     * @Description 查询用户信息
     *
     * @param user 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUserEntity>
     */
    List<SysUserEntity> findUserList(SysUserEntity user);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 根据用户ID查询用户信息
     *
     * @param userId 用户ID
     * @return com.www.demo.model.SysUserEntity 用户信息
     */
    SysUserEntity selectByPrimaryKey(String userId);
    /**
     * @Author www
     * @Date 2021/5/19 23:41
     * @Description 插入用户信息（更新非空数据）
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    int insertSelective(SysUserEntity record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据主键更新用户信息（更新非空数据）
     *
     * @param record 用户信息
     * @return int 插入条数
     */
    int updateByPrimaryKeySelective(SysUserEntity record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 根据用户信息（更新非空数据）查询用户信息
     *
     * @param record 用户信息
     * @return int 用户信息
     */
    SysUserEntity selective(SysUserEntity record);
}
