package com.example.onlineeduplatformlecture.service;


import com.example.onlineeduplatformlecture.model.Rating;
import reactor.core.publisher.Mono;

public interface PracticeProducerService {
    public void sendMessage(Rating message);
}
