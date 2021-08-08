package com.www.demo.websocket.configs;

import com.alibaba.fastjson.JSON;
import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import com.www.demo.websocket.pojo.Message;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>@Description WebSocket 聊天服务端
 *  ServerEndpoint WebSocket服务端 需指定端点的访问路径
 *  session   WebSocket会话对象 通过它给客户端发送消息
 * </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:16 </p>
 */
@Component
@ServerEndpoint("/ws/{userId}") //配置websocket的连接路径
public class WebSocketServer {
	private static Logger LOG = LoggerFactory.getLogger(WebSocketServer.class);
	/** 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。**/
	private static Map<String, WebSocketServer> onlineSessions = new ConcurrentHashMap<>();
	/**  当前会话对象 ***/
	private Session session;
	/** 当前用户 **/
	private String userId;

	private static ISysUserService sysUserService;
	/**
	 * <p>@Description 当客户端连接到服务端处理方法 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:17 </p>
	 * @param session 会话对象
	 * @param userId 用户ID
	 * @return void
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId) {
		LOG.info("-----> userId="+userId+" 打开连接。。。");
		this.session = session;
		this.userId = userId;
		onlineSessions.put(userId, this);
		Message message = new Message();
		message.setType(Message.ONLINE);
		message.setUserId(userId);
		//查询当前所有在线用户信息
		List<SysUser> userList = new ArrayList<>();
		onlineSessions.forEach((userIdTemp, webSocketServer) -> {
			SysUser user = sysUserService.selectByUserId(userIdTemp);
			user.setPassWord(null);
			userList.add(user);
		});
		message.setUserList(userList);
		String msg = Message.jsonStr(message);
		sendMessageToAll(null,msg);
	}
	/**
	 * <p>@Description 收到客户端发送的消息处理方法 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:17 </p>
	 * @param session 客户端的会话对象
	 * @param jsonStr 消息内容
	 * @return void
	 */
	@OnMessage
	public void onMessage(Session session, String jsonStr) {
		LOG.info("-----> userId={} 发送消息：{}",this.userId,jsonStr);
		Message message = JSON.parseObject(jsonStr, Message.class);
		message.setType(Message.SPEAK);
		//接收人ID不为空，单独发送消息
		if (StringUtils.isNotBlank(message.getReceiveId())){
            sendMessageToOne(message.getReceiveId(),Message.jsonStr(message));
        }else {//接收人ID为空，群发消息
            sendMessageToAll(this.userId,Message.jsonStr(message));
        }
	}
	/**
	 * <p>@Description 客户端断开连接处理方法 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:17 </p>
	 * @return void
	 */
	@OnClose
	public void onClose() {
		LOG.info("-----> userId={} 关闭连接。。。",this.userId);
		onlineSessions.remove(userId);
	}
	/**
	 * <p>@Description 通信发生异常处理 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:18 </p>
	 * @param session 会话对象
	 * @param error 异常信息
	 * @return void
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		LOG.info("-----> userId={} 发送异常。。。",this.userId);
		error.printStackTrace();
	}
	/**
	 * <p>@Description 发送信息给所有人 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:18 </p>
	 * @param userId 用户ID
	 * @param msg 消息
	 * @return void
	 */
	private static void sendMessageToAll(String userId,String msg) {
		onlineSessions.forEach((userIdTemp, webSocketServer) -> {
			try {
				if(!userIdTemp.equals(userId)){
					webSocketServer.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			}
		});
	}
    /**
	 * <p>@Description 发送消息到指定用户 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:18 </p>
	 * @param receiveUsrId 接收的用户ID
	 * @param msg 消息
	 * @return void
	 */
	private void sendMessageToOne(String receiveUsrId,String msg){
	    if (onlineSessions.containsKey(receiveUsrId)){
	        try {
                LOG.info("-----> 用户ID：{} 发送消息到用户ID：{},消息内容：{}",this.userId,receiveUsrId,msg);
                onlineSessions.get(receiveUsrId).session.getBasicRemote().sendText(msg);
            }catch (Exception e){
				LOG.error(e.getMessage());
            }
        }else {
			LOG.info("-----> 用户ID：{} 不在线,接收消息失败",receiveUsrId);
        }
    }

    @Autowired
	public void setSysUserService(ISysUserService sysUserService) {
		WebSocketServer.sysUserService = sysUserService;
	}
}