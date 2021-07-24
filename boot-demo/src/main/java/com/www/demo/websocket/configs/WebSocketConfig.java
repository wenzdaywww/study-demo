package com.www.demo.websocket.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @version 1.0
 * @Description websocket配置类,开启WebSocket支持
 * @Author www
 * @Date 2021/5/24 23:39
 */
@Configuration
public class WebSocketConfig {
	/**
	 * @Description 用于扫描和注册所有携带ServerEndPoint注解的实例。
	 * 若部署到外部容器 则无需提供此类。
	 * @version 1.0
	 * @Author www
	 * @Date 2021/5/24 23:38
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
