package com.venky.demos.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfigTopic {

    @Value("${app.kafka.user-topic}")
    private String userTopic;

    @Bean
    public NewTopic userTopic() {
        return TopicBuilder.name(userTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
