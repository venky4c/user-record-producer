package com.venky.demos.config;

import com.venky.demos.model.UserEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaSharedConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${app.kafka.user-topic}")
    private String userTopic;

    // 1. Reusable Base Properties Factory Method
    private Map<String, Object> getBaseConfig() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return configProps;
    }

    // 2. Shared Topic Creation (Always active across all experiments)
    @Bean
    public NewTopic sharedUserTopic() {
        return TopicBuilder.name(userTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    // 3. Config Variation A: Activated ONLY when profile is 'basic-string'
    @Bean
    @Profile("basic-string")
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        Map<String, Object> props = getBaseConfig();
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<>(props);
        return new KafkaTemplate<>(factory);
    }

    // 4. Config Variation B: Activated ONLY when profile is 'record-json'
    @Bean
    @Profile("record-json")
    public KafkaTemplate<String, UserEvent> recordKafkaTemplate() {
        Map<String, Object> props = getBaseConfig();
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);

        ProducerFactory<String, UserEvent> factory = new DefaultKafkaProducerFactory<>(props);
        return new KafkaTemplate<>(factory);
    }
}