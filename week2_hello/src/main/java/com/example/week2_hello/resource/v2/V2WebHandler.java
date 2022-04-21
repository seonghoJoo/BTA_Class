package com.example.week2_hello.resource.v2;

import com.example.week2_hello.resource.v2.vo.resp.InfoResponseDto;
import com.example.week2_hello.resource.v2.vo.resp.PersonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;



@Component
public class V2WebHandler {

    @Autowired
    private WebClient webClient;

    // 과제2
    public Mono<ServerResponse> hello(ServerRequest request) {
        String name = request.queryParam("name").get();

         return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(
                        webClient
                                .get()
                                .uri("/info-service/uri?name="+name)
                                .accept(MediaType.APPLICATION_JSON)
                                .retrieve()
                                .bodyToMono(InfoResponseDto.class)
                                .map(p-> new PersonResponseDto(name,name, p.getJob()))
                ,PersonResponseDto.class);
    }
}
