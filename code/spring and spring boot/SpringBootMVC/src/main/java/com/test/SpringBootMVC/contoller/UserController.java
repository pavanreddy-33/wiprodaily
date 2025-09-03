package com.test.SpringBootMVC.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.SpringBootMVC.model.User;

@Controller
public class UserController {
	
	@RequestMapping("/login")
	public String userLoginPage() {
		return "login";
	}
	
	@RequestMapping("/submitPage")
	public String submitPage(@RequestParam("user")String user,@RequestParam("pwd")String pass,Model model) {
		if(user.equals("admin")&&pass.equals("java")) {
			User obj = new User();
			obj.setUserName(user);
			obj.setPassword(pass);
			
			model.addAttribute("info",obj);
			
			return "success";
		}else {
			return "login";
		}
	}
}
