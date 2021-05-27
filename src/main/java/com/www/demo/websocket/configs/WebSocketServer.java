package com.www.demo.websocket.configs;

import com.alibaba.fastjson.JSON;
import com.www.demo.websocket.pojo.Message;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Description WebSocket 聊天服务端
 * ServerEndpoint WebSocket服务端 需指定端点的访问路径
 * Session   WebSocket会话对象 通过它给客户端发送消息
 * @Author www
 * @Date 2021/5/24 23:36
 */
@Component
@ServerEndpoint("/ws/{userId}") //配置websocket的连接路径
public class WebSocketServer {
	/** 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。**/
	private static Map<String, WebSocketServer> onlineSessions = new ConcurrentHashMap<>();
	/**  当前会话对象 ***/
	private Session session;
	/** 当前用户 **/
	private String userId;

	/**
	 * @Author www
	 * @Date 2021/5/27 22:59
	 * @Description 当客户端连接到服务端处理方法
	 *
	 * @param session 会话对象
	 * @return void
	 */
	@OnOpen
	public void onOpen(Session session, @PathParam("userId") String userId) {
		System.out.println("userId="+userId+" 打开连接。。。");
		this.session = session;
		this.userId = userId;
		onlineSessions.put(userId, this);
	}
	/**
	 * @Author www
	 * @Date 2021/5/27 22:59
	 * @Description 收到客户端发送的消息处理方法
	 *
	 * @param session 客户端的会话对象
	 * @param jsonStr 消息内容
	 * @return void
	 */
	@OnMessage
	public void onMessage(Session session, String jsonStr) {
		System.out.println("userId="+this.userId+" 发送消息："+jsonStr);
		Message message = JSON.parseObject(jsonStr, Message.class);
		//接收人ID不为空，单独发送消息
		if (StringUtils.isNotBlank(message.getReceiveId())){
            sendMessageToOne(message.getReceiveId(),Message.jsonStr(Message.SPEAK, message.getUserId(),message.getReceiveId(), message.getMsg(), onlineSessions.size()));
        }else {//接收人ID为空，群发消息
            sendMessageToAll(this.userId,Message.jsonStr(Message.SPEAK, message.getUserId(),message.getReceiveId(), message.getMsg(), onlineSessions.size()));
        }
	}
	/**
	 * @Author www
	 * @Date 2021/5/27 23:01
	 * @Description 客户端断开连接处理方法
	 *
	 * @return void
	 */
	@OnClose
	public void onClose() {
		System.out.println("userId="+userId+" 关闭连接。。。");
		onlineSessions.remove(userId);
	}
	/**
	 * @Author www
	 * @Date 2021/5/27 23:02
	 * @Description 通信发生异常处理
	 *
	 * @param session 会话对象
	 * @param error 异常信息
	 * @return void
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("userId="+userId+" 发送异常。。。");
		error.printStackTrace();
	}
	/**
	 * @Author www
	 * @Date 2021/5/27 22:58
	 * @Description 发送信息给所有人
	 *
	 * @param userId 用户ID
	 * @param msg 消息
	 * @return void
	 */
	private static void sendMessageToAll(String userId,String msg) {
		onlineSessions.forEach((userIdTemp, sessionTemp) -> {
			try {
				if(!userIdTemp.equals(userId)){
					sessionTemp.session.getBasicRemote().sendText(msg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
    /**
     * @Author www
     * @Date 2021/5/28 00:03
     * @Description 发送消息到指定用户
     *
     * @param receiveUsrId 接收的用户ID
     * @param msg 消息
     * @return void
     */
	private void sendMessageToOne(String receiveUsrId,String msg){
	    if (onlineSessions.containsKey(receiveUsrId)){
	        try {
                System.out.println("用户ID："+this.userId+"发送消息到用户ID："+receiveUsrId + ",消息内容："+msg);
                onlineSessions.get(receiveUsrId).session.getBasicRemote().sendText(msg);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("用户ID："+receiveUsrId + "不在线,接收消息失败");
        }
    }
}