package com.www.demo.websocket.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @version 1.0
 * @Description websocket控制层
 * @Author www
 * @Date 2021/5/24 23:53
 */
@Controller
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
	@GetMapping("/ws/login")
	public ModelAndView login() {
		return new ModelAndView("/websocket/login");
	}
	/**
	 * @Author www
	 * @Date 2021/5/24 23:35
	 * @Description 聊天页面
	 * 集成shiro实现登录拦截
	 * @param userId
	 * @param password
	 * @param request
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	@RequestMapping("/ws/chat/{userId}/{password}")
	public String chat(@PathVariable("userId") String userId, @PathVariable("password") String password, HttpServletRequest request, Model model) throws UnknownHostException {
		System.out.println("-----websocket登录-----");
		//获取当前用户
		Subject subject = SecurityUtils.getSubject();
		//封装用户的登录信息
		UsernamePasswordToken token = new UsernamePasswordToken(userId,password);
		try {
			//执行登录方法，将请求的用户和密码传递到Realm的doGetAuthenticationInfo判断，没有异常则登录成功
			subject.login(token);
			//查询用户
			SysUserEntity reqUser = new SysUserEntity();
			reqUser.setUserId(userId);
			SysUserEntity user = sysUserService.selective(reqUser);
			if (user != null){
				model.addAttribute("userId",user.getUserId());
				model.addAttribute("userName",user.getUserName());
			}else {
				throw new UnknownAccountException();
			}
			/** http下使用ws://xxx   https下使用wss://xxx */
			model.addAttribute("webSocketUrl","wss://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/ws");
			return "/websocket/chat";
		}catch (Exception e){
			model.addAttribute("info","用户名或密码错误！！！");
			return "/websocket/login";
		}
	}
}

