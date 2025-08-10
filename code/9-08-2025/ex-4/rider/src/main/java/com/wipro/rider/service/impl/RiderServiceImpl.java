package com.wipro.rider.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.rider.dto.Ride;
import com.wipro.rider.entity.Rider;
import com.wipro.rider.repo.RiderRepo;
import com.wipro.rider.service.RiderService;
import com.wipro.rider.util.AppConstant;

@Service
public class RiderServiceImpl implements RiderService {
	
	
	@Autowired
	RiderRepo repo;
	
	@Autowired
	KafkaTemplate<String, Ride> kafkaTemplate;

	@Override
    public Rider save(Rider r) {
        r.setStatus("PENDING");
        r.setTimestamp(LocalDateTime.now());
        Rider saved = repo.save(r);

        Ride msg = new Ride();
        msg.setId(saved.getId());
        msg.setRiderName(saved.getRiderName());
        msg.setPickup(saved.getPickup());
        msg.setDropLocation(saved.getDropLocation());
        msg.setStatus(saved.getStatus());
        msg.setTimestamp(saved.getTimestamp());

        kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, msg);
        return saved;
    }

    @KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "rider_group", containerFactory = "kafkaListenerContainerFactory")
    public void receiveFromUber(Ride ride) {
        System.out.println("[Rider] Message received: " + ride);
        Optional<Rider> opt = repo.findById(ride.getId());
        if(opt.isPresent()) {
            Rider r = opt.get();
            r.setStatus(ride.getStatus());
            repo.save(r);
        }
    }
	
	

}
