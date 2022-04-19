package com.example.week2_info;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class InfoHandler {

    // 과제2
    public Mono<ServerResponse> info_service_uri(ServerRequest request) {
        String name = request.queryParam("name").get();

        System.out.println(name);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(new InfoServiceResponseDto(""))
                                , InfoServiceResponseDto.class
                );
    }
}
