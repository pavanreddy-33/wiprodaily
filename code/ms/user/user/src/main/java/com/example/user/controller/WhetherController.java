package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dto.Mobile;
import com.example.user.service.MobileService;

@RestController
@RequestMapping("/mobiles")
public class WhetherController {
	
	@Autowired
	MobileService mobileService;
	
	@PostMapping
	void postMobile(@RequestBody Mobile mobile) {
		mobileService.postMobile(mobile);
	}
	
	@PutMapping
	void updateMobile(@RequestBody Mobile mobile) {
		mobileService.updateMobile(mobile);
	}
	
	@GetMapping
	Mobile getMobileByName(String name){
		return mobileService.getMobileByName(name);
	}
	
	@GetMapping
	List<Mobile> getMobile(){
		return mobileService.getMobile();
	}
	
	@DeleteMapping
	void deleteMobile(@RequestBody Mobile mobile) {
		mobileService.deleteMobile(mobile);
		
	}
	
}
