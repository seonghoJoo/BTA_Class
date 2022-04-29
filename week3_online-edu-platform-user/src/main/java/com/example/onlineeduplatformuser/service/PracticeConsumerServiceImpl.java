package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.model.Rating;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PracticeConsumerServiceImpl implements PracticeConsumerService {

    private final Logger logger = LoggerFactory.getLogger(PracticeConsumerService.class);

    @KafkaListener(topics = "test", groupId = "first-group", containerFactory = "kafkaListenerContainerFactory" ,
            properties = {"spring.json.value.default.type=com.example.onlineeduplatformuser.model.Rating"})
    public void consume(Rating rating) {
        logger.info(String.format("#### -> Consumed message -> %s", rating.getUserId()));
    }

//    @KafkaListener(topics = "test")
//    public void processMessage(Rating message) {
//        System.out.println("Message received by consumer 1: " + message.toString());
//    }
}