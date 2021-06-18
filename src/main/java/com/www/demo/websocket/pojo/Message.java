package com.www.demo.websocket.pojo;

import com.alibaba.fastjson.JSON;
import com.www.demo.model.entity.SysUserEntity;

import java.util.List;

/**
 * @version 1.0
 * @Description WebSocket 聊天消息类
 * @Author www
 * @Date 2021/5/28 00:09
 */
public class Message {
    /** 发言 **/
    public static final String SPEAK = "SPEAK";
    /** 在线人数 **/
    public static final String ONLINE = "ONLINE";
    /** 进入 **/
    public static final String QUIT = "QUIT";
    /** 离开 **/
    public static final String ENTER = "ENTER";
    /**消息类型**/
    private String type;

    /**发送人ID**/
    private String userId;

    /**发送人名称**/
    private String userName;

    /**接收人ID**/
    private String receiveId;

    /**接收人名称**/
    private String receiveName;

    /**发送消息**/
    private String msg; 

    /**在线用户数**/
    private int onlineCount;
    /** 在线用户信息 **/
    private List<SysUserEntity> userList;

    public static String jsonStr(String type, String userId,String receiveId, String msg, int onlineTotal) {
        return JSON.toJSONString(new Message(type, userId,receiveId, msg, onlineTotal));
    }

    public static String jsonStr(Message message) {
        return JSON.toJSONString(message);
    }

    public Message(){

    }

    public Message(String type, String userId, String receiveId,String msg, int onlineCount) {
        this.type = type;
        this.userId = userId;
        this.receiveId = receiveId;
        this.msg = msg;
        this.onlineCount = onlineCount;
    }

    public List<SysUserEntity> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUserEntity> userList) {
        this.userList = userList;
    }

    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getOnlineCount() {
        return onlineCount;
    }

    public void setOnlineCount(int onlineCount) {
        this.onlineCount = onlineCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }
}
