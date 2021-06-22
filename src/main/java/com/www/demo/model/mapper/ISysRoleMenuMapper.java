package com.www.demo.model.mapper;

import com.www.demo.model.entity.SysMenuEntity;
import com.www.demo.model.entity.SysRoleEntity;
import com.www.demo.model.entity.SysRoleMenuEntity;
import com.www.demo.model.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @Description 菜单角色表Mapper
 * @Author www
 * @Date 2021/6/18 20:56
 */
public interface ISysRoleMenuMapper {
    /**
     * @Author www
     * @Date 2021/6/18 21:22
     * @Description 根据角色ID查询所有菜单
     *
     * @param roleList 角色ID集合
     * @return java.util.List<com.www.demo.model.entity.SysMenuEntity>
     */
    List<SysMenuEntity> findMenuList(@Param("roleList") List<SysRoleEntity> roleList);
    /**
     * @Author www
     * @Date 2021/6/18 21:08
     * @Description 根据角色菜单id删除数据
     *
     * @param sysRoleMenuId 角色菜单id
     * @return int
     */
    int deleteByPrimaryKey(BigDecimal sysRoleMenuId);
    /**
     * @Author www
     * @Date 2021/6/18 21:08
     * @Description 插入角色菜单信息
     *
     * @param record 角色菜单信息
     * @return int
     */
    int insert(SysRoleMenuEntity record);
    /**
     * @Author www
     * @Date 2021/6/18 21:08
     * @Description 插入非空的角色菜单信息
     *
     * @param record 角色菜单信息
     * @return int
     */
    int insertSelective(SysRoleMenuEntity record);
    /**
     * @Author www
     * @Date 2021/6/18 21:08
     * @Description 根据角色菜单id查询角色菜单信息
     *
     * @param sysRoleMenuId 角色菜单id
     * @return com.www.demo.model.entity.SysRoleMenuEntity
     */
    SysRoleMenuEntity selectByPrimaryKey(BigDecimal sysRoleMenuId);
    /**
     * @Author www
     * @Date 2021/6/18 21:08
     * @Description 根据角色菜单id更新非空的角色菜单信息
     *
     * @param record 角色菜单信息
     * @return int
     */
    int updateByPrimaryKeySelective(SysRoleMenuEntity record);
    /**
     * @Author www
     * @Date 2021/6/18 21:08
     * @Description 根据角色菜单id更新角色菜单信息
     *
     * @param record 角色菜单信息
     * @return int
     */
    int updateByPrimaryKey(SysRoleMenuEntity record);
}