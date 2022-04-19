package com.example.week2_hello.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Component
public class MyWebHandler {

    //Router Function 모델

    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.queryParam("name").get();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(
                Mono.just(new PersonResponseDto(name,name))
                .map(person -> {
                    person.modMessage(name);
                    return person;
                }), PersonResponseDto.class);
    }

    @Getter
    @AllArgsConstructor
    public class PersonResponseDto{
        private String to;
        private String message;

        public void modMessage(String message){
            this.message = "hello " +  message;
        }
    }
}
