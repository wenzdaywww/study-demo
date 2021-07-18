package com.www.demo.model.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.www.demo.model.entity.SysMenu;
import com.www.demo.model.entity.SysRole;
import com.www.demo.model.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description 角色菜单Mapper
 * @version 1.0
 * @author www
 * @date 2021/7/18 19:23
 */
public interface ISysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    /**
     * @Author www
     * @Date 2021/6/18 21:22
     * @Description 根据角色ID查询所有菜单
     * @param roleList 角色ID集合
     * @return java.util.List<com.www.demo.model.entity.SysMenuEntity>
     */
    List<SysMenu> findMenuList(@Param("roleList") List<SysRole> roleList);
}