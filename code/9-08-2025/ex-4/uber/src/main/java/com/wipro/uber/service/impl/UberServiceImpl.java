package com.wipro.uber.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


import com.wipro.rider.util.AppConstant;
import com.wipro.uber.dto.Ride;
import com.wipro.uber.entity.Uber;
import com.wipro.uber.repo.UberRepo;
import com.wipro.uber.service.UberService;

@Service
public class UberServiceImpl implements UberService {

	@Autowired
	UberRepo repo;
	
	@Autowired
	KafkaTemplate<String, Ride> kafkaTemplate;
	
    @Override
    @KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "uber_group", containerFactory = "kafkaListenerContainerFactory")
    public void processRide(Ride ride) {
        System.out.println("[Uber] Received ride: " + ride);
        Uber a = new Uber();
        a.setRiderName(ride.getRiderName());
        a.setPickup(ride.getPickup());
        a.setDropLocation(ride.getDropLocation());
        a.setStatus("ACCEPTED");
        a.setTimestamp(LocalDateTime.now());
        Uber saved = repo.save(a);

        // send update back with original id so Rider can correlate
        Ride resp = new Ride();
        resp.setId(ride.getId());
        resp.setRiderName(saved.getRiderName());
        resp.setPickup(saved.getPickup());
        resp.setDropLocation(saved.getDropLocation());
        resp.setStatus(saved.getStatus());
        resp.setTimestamp(saved.getTimestamp());

        kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, resp);
    }

	

}
