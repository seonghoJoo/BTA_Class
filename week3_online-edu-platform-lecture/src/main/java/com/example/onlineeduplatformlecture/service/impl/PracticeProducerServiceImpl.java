package com.example.onlineeduplatformlecture.service.impl;

import com.example.onlineeduplatformlecture.model.Rating;
import com.example.onlineeduplatformlecture.service.PracticeProducerService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.kafka.sender.KafkaSender;

import javax.annotation.PreDestroy;

@Service

public class PracticeProducerServiceImpl implements PracticeProducerService {

    private static final Logger logger = LoggerFactory.getLogger(PracticeProducerServiceImpl.class);
    private static final String TOPIC = "test";

    @Autowired
    KafkaTemplate<String, Rating> ratingKafkaTemplate;

    public void sendMessage(Rating message) {
        logger.info(String.format("#### -> Producing message -> %s", message.toString()));
        this.ratingKafkaTemplate.send(TOPIC ,message);
    }

}
