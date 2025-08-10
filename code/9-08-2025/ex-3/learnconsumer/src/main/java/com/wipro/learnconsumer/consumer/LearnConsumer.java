package com.wipro.learnconsumer.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class LearnConsumer {
	@KafkaListener(topics = "learn-subject", groupId = "group_id")
    public void consume(String msg) {
        System.out.println("Consumed message: " + msg);
    }
}
