package com.wipro.learnproducer.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.learnproducer.dto.Learn;
import com.wipro.learnproducer.service.LearnService;

@RestController
@RequestMapping("/learn")
public class LearnController {
	
	@Autowired
	LearnService learnService;
	
	@PostMapping
	void sendLearnData(@RequestBody Learn learn)
	{
		learnService.sendLearnData(learn);
	}
}
