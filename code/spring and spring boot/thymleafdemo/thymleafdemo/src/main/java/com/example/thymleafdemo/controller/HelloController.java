package com.example.thymleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/hi")
	String showWelcome(Model m)
	{
		m.addAttribute("name", "Pavan");
		return "thy";		
	}

}
