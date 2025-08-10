package com.example.cityjsp.controller;

import com.example.cityjsp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public String showCities(Model model) {
        model.addAttribute("citylist", cityService.getAllCities());
        return "citylist";
    }
}
