package com.www.demo.model.mapper;

import com.www.demo.model.entity.SysUserRole;

import java.util.List;

/**
 * @version 1.0
 * @Description SysUserRoleMapper接口
 * @Author www
 * @Date 2021/5/19 23:39
 */
public interface ISysUserRoleMapper {
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 插入用户角色信息
     *
     * @param record 用户角色信息
     * @return int 插入条数
     */
    int insert(SysUserRole record);
    /**
     * @Author www
     * @Date 2021/5/19 23:42
     * @Description 插入用户角色信息（插入非空数据）
     *
     * @param record 用户角色信息
     * @return int 插入条数
     */
    int insertSelective(SysUserRole record);

    /**
     * @Author www
     * @Date 2021/6/15 23:20
     * @Description 查询用户的角色信息
     *
     * @param record 查询条件
     * @return java.util.List<com.www.demo.model.entity.SysUserRole>
     */
    List<SysUserRole> selective(SysUserRole record);
}