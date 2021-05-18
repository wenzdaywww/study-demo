package com.www.demo.app.controller;

import com.www.demo.app.service.IMyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 控制层
 * @author www
 *
 */
@Controller
public class MyController {
	@Autowired
	private IMyService myService;
	
	@RequestMapping("/info")
	public String index(Model model) {

		return "info";
	}
	
	@RequestMapping("/rollback")
	public void rollBackTest(String userid,String oldpasswd,String newpasswd) {

	}
	
	@RequestMapping("/norollback")
	public void noRollBackTest(String userid,String oldpasswd,String newpasswd) {

	}
}
