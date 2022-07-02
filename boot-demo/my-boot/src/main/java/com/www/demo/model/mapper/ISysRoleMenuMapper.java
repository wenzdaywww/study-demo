package com.www.demo.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.www.demo.model.entity.SysMenuEntity;
import com.www.demo.model.entity.SysRoleEntity;
import com.www.demo.model.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>@Description 角色菜单Mapper </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 20:58 </p>
 */
public interface ISysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {
    /**
     * <p>@Description 根据角色ID查询所有菜单 </p>
     * <p>@Author www </p>
     * <p>@Date 2021/8/1 20:58 </p>
     * @param roleList 角色ID集合
     * @return java.util.List<com.www.demo.model.entity.SysMenu>
     */
    List<SysMenuEntity> findMenuList(@Param("roleList") List<SysRoleEntity> roleList);
}