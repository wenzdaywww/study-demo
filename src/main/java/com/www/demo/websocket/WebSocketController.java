package com.www.demo.websocket;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class WebSocketController {

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/websocket/login");
	}
	@GetMapping("/chat")
	public ModelAndView chat(String username,String password,HttpServletRequest request) throws UnknownHostException {
		if (StringUtils.isEmpty(username)) {
			username = "匿名用户";
		}
		ModelAndView modelAndView = new ModelAndView("/websocket/chat");
		modelAndView.addObject("username",username);
		/**
		 * http下使用ws://xxx   https下使用wss://xxx
		 */
		modelAndView.addObject("webSocketUrl","wss://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/ws");
		return modelAndView;
	}
}

