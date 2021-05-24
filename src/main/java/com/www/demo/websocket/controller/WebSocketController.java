package com.www.demo.websocket.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import com.www.demo.model.mapper.ISysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @Description websocket控制层
 * @Author www
 * @Date 2021/5/24 23:53
 */
@RestController("/ws")
public class WebSocketController {
	@Autowired
	private ISysUserService sysUserService;
	/**
	 * @Author www
	 * @Date 2021/5/24 23:35
	 * @Description 登入页面
	 *
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("/websocket/login");
	}
	/**
	 * @Author www
	 * @Date 2021/5/24 23:35
	 * @Description 聊天页面
	 *
	 * @param username
	 * @param password
	 * @param request
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	@GetMapping("/chat/{name}/{psd}")
	public ModelAndView chat(@PathVariable("name") String username, @PathVariable("psd") String password, HttpServletRequest request) throws UnknownHostException {
		SysUser reqUser = new SysUser();
		reqUser.setUserName(username);
		reqUser.setPassWord(password);
		SysUser user = sysUserService.selective(reqUser);
		if (user==null) {
			ModelAndView modelAndView = new ModelAndView("/websocket/login");
			modelAndView.addObject("info","用户名或密码错误！！！");
			return modelAndView;
		}else {
			ModelAndView modelAndView = new ModelAndView("/websocket/chat");
			modelAndView.addObject("username",user.getUserName());
			/**
			 * http下使用ws://xxx   https下使用wss://xxx
			 */
			modelAndView.addObject("webSocketUrl","wss://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/ws");
			return modelAndView;
		}
	}
}

