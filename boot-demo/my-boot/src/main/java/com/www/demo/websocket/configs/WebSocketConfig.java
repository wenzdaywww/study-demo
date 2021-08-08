package com.www.demo.websocket.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * <p>@Description websocket配置类,开启WebSocket支持 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:16 </p>
 */
@Configuration
public class WebSocketConfig {
	/**
	 * <p>@Description 用于扫描和注册所有携带ServerEndPoint注解的实例。
	 * 若部署到外部容器 则无需提供此类。 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:16 </p>
	 * @return org.springframework.web.socket.server.standard.ServerEndpointExporter
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
