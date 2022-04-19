package com.example.week2_hello;

import com.example.week2_hello.resource.v1.V1WebHandler;
import com.example.week2_hello.resource.v2.V2WebHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    //Router Function 모델
    @Bean
    public RouterFunction<ServerResponse> routerExample(V2WebHandler handler) {
        return RouterFunctions.route()
                .GET("/hello", accept(APPLICATION_JSON), handler::hello)
                .build();
    }


}
