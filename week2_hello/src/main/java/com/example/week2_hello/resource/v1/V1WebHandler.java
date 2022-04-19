package com.example.week2_hello.resource.v1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class V1WebHandler {

    // Router Function 모델
    // 과제 1
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
