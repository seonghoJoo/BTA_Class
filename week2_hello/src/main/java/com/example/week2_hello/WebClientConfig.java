package com.example.week2_hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableWebFlux
public class WebClientConfig {

    @Bean
    public WebClient webClient(){
        return  WebClient.builder()
                .baseUrl("http://localhost:8092")
                .build();
    }

}
