package com.example.week2_user.config;

import com.example.week2_user.controller.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    //Router Function 모델
    @Bean
    public RouterFunction<ServerResponse> routerExample(UserHandler userHandler) {
        return RouterFunctions.route()
                .POST("/user", accept(APPLICATION_JSON), userHandler::register)
                .build();
    }


}
