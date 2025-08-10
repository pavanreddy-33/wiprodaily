package com.wipro.rider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rider.entity.Rider;
import com.wipro.rider.service.RiderService;

@RestController
@RequestMapping("/ride")
public class RiderController {
	
	@Autowired
	RiderService riderService;
	
	@PostMapping
    public ResponseEntity<Rider> save(@RequestBody Rider r) {
        Rider saved = riderService.save(r);
        return ResponseEntity.ok(saved);
    }
}
