package com.www.demo.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.www.demo.app.service.IMyService;
import com.www.demo.model.vo.People;
import com.www.demo.model.vo.SysuserVO;
@Controller
public class MyController {
	@Autowired
	private IMyService myService;
	
	@RequestMapping("/info")
	public String index(Model model) {
		People single = new People("www", "18");
		List<People> people = new ArrayList<People>();
		People people1 = new People("张三", "18");
		People people2 = new People("李四", "19");
		People people3 = new People("王五", "20");
		people.add(people1);
		people.add(people2);
		people.add(people3);
		
		model.addAttribute("single", single);
		model.addAttribute("people", people);
		return "info";
	}
	
	@RequestMapping("/rollback")
	public void rollBackTest(String userid,String oldpasswd,String newpasswd) {
		myService.modifyUserPawsswdWithRollBack(new SysuserVO(userid, null, null, oldpasswd, newpasswd));
	}
	
	@RequestMapping("/norollback")
	public void noRollBackTest(String userid,String oldpasswd,String newpasswd) {
		myService.modifyUserPawsswdWithoutRollBack(new SysuserVO(userid, null, null, oldpasswd, newpasswd));
	}
}
