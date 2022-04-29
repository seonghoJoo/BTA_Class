package com.example.onlineeduplatformuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OnlineEduPlatformUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEduPlatformUserApplication.class, args);
    }

}
