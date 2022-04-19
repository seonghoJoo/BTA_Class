package com.example.week2_hello.resource.v2;

import com.example.week2_hello.WebClientConfig;
import com.example.week2_hello.resource.v1.V1WebHandler;
import com.example.week2_hello.resource.v2.vo.resp.InfoResponseDto;
import com.example.week2_hello.resource.v2.vo.resp.PersonResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
public class V2WebHandler {

    private final String BASE_URL = "http://localhost:8092";

    // 과제2
    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.queryParam("name").get();


        WebClient client = WebClient.create(BASE_URL);

        Mono<InfoResponseDto> result = client.get()
                .uri("/info_service/uri?name={name}", name)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(InfoResponseDto.class);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(
                    Mono.just(new PersonResponseDto(name,name,""))
                            .map(person -> {
                                person.modMessage(name);
                                return person;
                            }), PersonResponseDto.class);

    }


}
