package com.www.demo.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.www.demo.model.entity.SysRole;
import com.www.demo.model.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>@Description 用户角色Mapper </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:58 </p>
 */
public interface ISysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * <p>@Description 根据用户ID查询用户拥有角色 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:59 </p>
     * @param userId 用户ID
     * @return java.util.List<com.www.demo.model.entity.SysRole> 角色集合
     */
    List<SysRole> findUserRoles(@Param("userId") String userId);
}