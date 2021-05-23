package com.www.demo.model.entity;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description 用户角色表对象
 * @Author www
 * @Date 2021/5/19 23:36
 */
public class SysUserRole implements Serializable {
    /**
     * 用户ID
     **/
    private String userId;
    /**
     * 角色ID
     **/
    private String roleId;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}