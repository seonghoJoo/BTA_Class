package com.example.week2_hello.config;

import com.example.week2_hello.resource.WebHandler;
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
	public RouterFunction<ServerResponse> routes(WebHandler handler) {
		return RouterFunctions.route(RequestPredicates.GET("/hello").and(accpet(MediaType.APPLICATION_JSON)), handler::hello);
	}
    
    @Bean
    public RouterFunction<ServerResponse> routerExample(WebHandler handler) {
        return RouterFunctions.route()
                .GET("/hello/{name}", accept(APPLICATION_JSON), handler::)
                .build();
    }
}
