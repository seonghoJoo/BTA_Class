package com.example.week2_hello;

import com.example.week2_hello.resource.MyWebHandler;
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
    public RouterFunction<ServerResponse> routerExample(MyWebHandler handler) {
        return RouterFunctions.route()
                .GET("/hello", accept(APPLICATION_JSON), handler::hello)
                .build();
    }
}
