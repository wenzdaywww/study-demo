package com.www.demo.model;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description 用户表对象
 * @Author www
 * @Date 2021/5/19 23:37
 */
public class SysUser implements Serializable {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 用户名称
     **/
    private String userName;
    /**
     * 用户密码
     **/
    private String passWord;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}