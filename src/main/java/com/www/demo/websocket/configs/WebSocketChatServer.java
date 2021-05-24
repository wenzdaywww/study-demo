package com.www.demo.websocket.configs;

import com.alibaba.fastjson.JSON;
import com.www.demo.websocket.pojo.Message;

import org.springframework.stereotype.Component;
import javax.websocket.*;
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
@ServerEndpoint("/ws")
public class WebSocketChatServer {

	/**
	 * 全部在线会话  PS: 基于场景考虑 这里使用线程安全的Map存储会话对象。
	 */
	private static Map<String, Session> onlineSessions = new ConcurrentHashMap<>();

	/**
	 * @Description 当客户端打开连接：1.添加会话对象 2.更新在线人数
	 * @version 1.0
	 * @Author www
	 * @Date 2021/5/24 23:37
	 */
	@OnOpen
	public void onOpen(Session session) {
		onlineSessions.put(session.getId(), session);
		sendMessageToAll(Message.jsonStr(Message.ENTER, "", "", onlineSessions.size()));
	}

	/**
	 * @Description 当客户端发送消息：1.获取它的用户名和消息 2.发送消息给所有人
	 * 	PS: 这里约定传递的消息为JSON字符串 方便传递更多参数！
	 * @version 1.0
	 * @Author www
	 * @Date 2021/5/24 23:37
	 */
	@OnMessage
	public void onMessage(Session session, String jsonStr) {
		Message message = JSON.parseObject(jsonStr, Message.class);
		sendMessageToAll(Message.jsonStr(Message.SPEAK, message.getUsername(), message.getMsg(), onlineSessions.size()));
	}
	/**
	 * @Description 当关闭连接：1.移除会话对象 2.更新在线人数
	 * @version 1.0
	 * @Author www
	 * @Date 2021/5/24 23:38
	 */
	@OnClose
	public void onClose(Session session) {
		onlineSessions.remove(session.getId());
		sendMessageToAll(Message.jsonStr(Message.QUIT, "", "", onlineSessions.size()));
	}
	/**
	 * @Description 当通信发生异常：打印错误日志
	 * @version 1.0
	 * @Author www
	 * @Date 2021/5/24 23:38
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		error.printStackTrace();
	}
	/**
	 * @Description 公共方法：发送信息给所有人
	 * @version 1.0
	 * @Author www
	 * @Date 2021/5/24 23:38
	 */
	private static void sendMessageToAll(String msg) {
		onlineSessions.forEach((id, session) -> {
			try {
				session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}