package com.www.demo.websocket.controller;

import com.www.demo.app.service.ISysUserService;
import com.www.demo.model.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p>@Description websocket控制层 </p>
 * <p>@Version 1.0 </p>
 * <p>@Author www </p>
 * <p>@Date 2021/8/1 21:18 </p>
 */
@Controller
public class WebSocketController {
    private static Logger LOG = LoggerFactory.getLogger(WebSocketController.class);

	@Autowired
	private ISysUserService sysUserService;
	/**
	 * <p>@Description 登入页面 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:18 </p>
	 * @return org.springframework.web.servlet.ModelAndView
	 */
	@GetMapping("/ws")
	public ModelAndView login() {
        LOG.info("-----> websocket登录页面");
	    return new ModelAndView("websocket/login");
	}
	/**
	 * <p>@Description 聊天页面，集成shiro实现登录拦截 </p>
	 * <p>@Author www </p>
	 * <p>@Date 2021/8/1 21:19 </p>
	 * @param userId 用户ID
	 * @param password 密码
	 * @param request 请求
	 * @param model model
	 * @return java.lang.String
	 */
	@PostMapping("/ws/login")
	public String chat(String userId, String password, HttpServletRequest request,Model model) throws UnknownHostException {
        LOG.info("-----> websocket登录认证");
		//获取当前用户
		Subject subject = SecurityUtils.getSubject();
		//封装用户的登录信息
		UsernamePasswordToken token = new UsernamePasswordToken(userId,password);
		try {
			//执行登录方法，将请求的用户和密码传递到Realm的doGetAuthenticationInfo判断，没有异常则登录成功
			subject.login(token);
			//查询用户
			SysUser user = sysUserService.selectByUserId(userId);
			if (user != null){
				HttpSession session = request.getSession();
				session.setAttribute("user",user);
			}else {
				model.addAttribute("info","用户名不存在！！！");
			}
			/** http下使用ws://xxx   https下使用wss://xxx */
			model.addAttribute("webSocketUrl","wss://"+ InetAddress.getLocalHost().getHostAddress()+":"+request.getServerPort()+request.getContextPath()+"/ws");
			return "redirect:/ws/index";
		}catch (Exception e){
			model.addAttribute("info","用户名或密码错误！！！");
			return "/ws/login";
		}
	}
}

