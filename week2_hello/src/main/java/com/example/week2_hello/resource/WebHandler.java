package com.example.week2_hello.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class WebHandler {

    //Router Function 모델

    public Mono<ServerResponse> hello(ServerRequest request, String name) {
        Mono<Person> person = Mono.just(new Person(name));
        return ServerResponse.ok().body(BodyInserters.fromValue(response));
    }

    @Getter
    @AllArgsConstructor
    public class Person{
        private String name;
    }
}
