package com.example.demo.controlle;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @RequestMapping("/userreg")
    public String showForm() {
        return "userreg";
    }

    @PostMapping("/submitUser")
    public String handleUserData(@ModelAttribute User user) {
        
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getUserEmail());
        System.out.println("Phone: " + user.getUserPhone());
        return "success"; 
    }
}
