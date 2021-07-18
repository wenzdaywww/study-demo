package com.www.demo.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.www.demo.model.entity.SysRole;
import com.www.demo.model.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 用户角色Mapper
 * @version 1.0
 * @author www
 * @date 2021/7/18 19:26
 */
public interface ISysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * @Author www
     * @Date 2021/6/22 22:00
     * @Description 根据用户ID查询用户拥有角色
     * @param userId 用户ID
     * @return java.util.List<com.www.demo.model.entity.SysRole> 角色集合
     */
    List<SysRole> findUserRoles(@Param("userId") String userId);
}