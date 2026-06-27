package com.venky.demos.strategy;

import com.venky.demos.model.UserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class IdempotentUpsertStrategy implements DeliveryStrategy{

    @Autowired
    private KafkaTemplate<String, UserEvent> kafkaTemplate;
    private final Map<String, UserEvent> cache = new ConcurrentHashMap<>();

    @Override
    public void processAndSend(String userId, UserEvent event) {
        if (event.equals(cache.get(userId))) return;
        cache.put(userId, event);
        kafkaTemplate.send("user-updates-topic", userId, event);
    }
}
