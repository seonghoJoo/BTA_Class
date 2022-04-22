package com.example.week2_user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebClientConfig {

    @Bean
    public WebClient webLectureClient(){
        return  WebClient.builder()
                .baseUrl("http://localhost:8081")
                .build();
    }

    @Bean
    public WebClient webCommunityClient(){
        return  WebClient.builder()
                .baseUrl("http://localhost:8082")
                .build();
    }

}
