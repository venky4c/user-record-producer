package com.venky.demos.service;

import com.venky.demos.model.UserEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, UserEvent> template;
    private final String userTopic;

    // Fully expanded constructor using constructor injection
    public KafkaProducerService(
            KafkaTemplate<String, UserEvent> template,
            @Value("${app.kafka.user-topic}") String userTopic) {
        this.template = template;
        this.userTopic = userTopic;
    }

    public void sendUserEvent(String userId, UserEvent event) {
        // Sends the Java record payload directly using the new serializer config
        template.send(userTopic, userId, event);
    }
}



//package com.venky.demos.service;
//
//import com.venky.demos.model.UserEvent;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class KafkaProducerService {
//
//    private final KafkaTemplate<String, String> template; // Changed generic type to String
//    private final String userTopic;
//
//    public KafkaProducerService(
//            KafkaTemplate<String, String> template, // Changed template injection type
//            @Value("${app.kafka.user-topic}") String userTopic) {
//        this.template = template;
//        this.userTopic = userTopic;
//    }
//
//    public void sendUserEvent(String userId, UserEvent event) {
//        // Convert the record payload to a standard String format
//        String stringPayload = event.toString();
//
//        // Alternative manual JSON string fallback if you prefer readable logs:
//        // String stringPayload = String.format("{\"userId\":\"%s\",\"email\":\"%s\",\"status\":\"%s\"}", event.userId(), event.email(), event.status());
//
//        template.send(userTopic, userId, stringPayload);
//    }
//}


//package com.venky.demos.service;
//
//import com.venky.demos.model.UserEvent;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//public class KafkaProducerService {
//
//    private final KafkaTemplate<String, UserEvent> template;
//    private final String userTopic;
//
//    public KafkaProducerService(
//            KafkaTemplate<String, UserEvent> template,
//            @Value("${app.kafka.user-topic}") String userTopic) {
//        this.template = template;
//        this.userTopic = userTopic;
//    }
//
//    public void sendUserEvent(String userId, UserEvent event) {
//        //log.info("Sending event to topic: {} for userId: {}", userTopic, userId);
//        template.send(userTopic, userId, event);
//    }
//}
