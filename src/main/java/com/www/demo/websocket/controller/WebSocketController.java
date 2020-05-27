package com.www.demo.websocket.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.www.demo.model.bo.system.SysUser;
import com.www.demo.model.bo.system.SysUserRepository;
/**
 * websocket控制层
 * @author www
 *
 */
@RestController("/ws")
public class WebSocketController {
	@Autowired
	private SysUserRepository userRepository;

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/websocket/login");
	}
	@GetMapping("/chat")
	public ModelAndView chat(String username,String password,HttpServletRequest request) throws UnknownHostException {
		SysUser user = userRepository.findWithuserNameAndPasswd(username, password);
		if (user==null) {
			ModelAndView modelAndView = new ModelAndView("/websocket/login");
			modelAndView.addObject("info","用户名或密码错误！！！");
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("/websocket/chat");
			modelAndView.addObject("username",user.getUsername());
			/**
			 * http下使用ws://xxx   https下使用wss://xxx
			 */
			modelAndView.addObject("webSocketUrl","wss://"+InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/ws");
			return modelAndView;
		}
	}
}

