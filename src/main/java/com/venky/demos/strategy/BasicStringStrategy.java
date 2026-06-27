package com.venky.demos.strategy;

import com.venky.demos.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Profile("basic-string")
public class BasicStringStrategy implements DeliveryStrategy{

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void processAndSend(String userId, UserEvent event) {
        kafkaTemplate.send(userId, event.toString());
    }
}
