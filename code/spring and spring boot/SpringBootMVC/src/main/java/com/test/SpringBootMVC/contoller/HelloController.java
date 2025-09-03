package com.test.SpringBootMVC.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/again")
	public String sayAgainHello() {
		return "hello1";
	}
}
