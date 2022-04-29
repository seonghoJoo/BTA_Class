package com.example.onlineeduplatformlecture.config;

import com.example.onlineeduplatformlecture.model.Rating;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
class KafkaConfig {

    private String topic="test";

    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String BOOTSTRAP_SERVER;

    @Bean
    public Map<String, Object> ratingProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
//        props.put(JsonSerializer.TYPE_MAPPINGS, "com.example.onlineeduplatformlecture.model.Rating");
        return props;
    }

    @Bean
    public ProducerFactory<String, Rating> ratingProducerFactory() {
        return new DefaultKafkaProducerFactory<>(ratingProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, Rating> ratingKafkaTemplate() {
        return new KafkaTemplate<>(ratingProducerFactory());
    }
}
