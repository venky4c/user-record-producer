package com.venky.demos.service;

import com.venky.demos.model.UserEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, UserEvent> template;
    // REMOVE 'final' so Lombok ignores it, and let Spring inject it directly into the field
    @Value("${app.kafka.user-topic}")
    private String userTopic;

    public void sendUserEvent(String userId, UserEvent event) {
        // Sends the Java record payload directly using the new serializer config
        template.send(userTopic, userId, event);
    }
}
