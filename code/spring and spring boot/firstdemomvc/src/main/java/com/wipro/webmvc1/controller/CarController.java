package com.wipro.webmvc1.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.wipro.webmvc1.service.ProdService;

@Controller
public class CarController {
    @Autowired
    private ProdService service;

    @GetMapping("/car/list")
    public String showCarList(Model m) {
        List<String> prodList = service.fetchCarList();
        m.addAttribute("prodList", prodList);
        return "carList";
    }
}
