package com.example.week2_info;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class InfoHandler {

    // 과제2
    public Mono<ServerResponse> info_service_uri(ServerRequest request) {
        String name = request.queryParam("name").get();

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(
                        Mono.just(new InfoServiceResponseDto(""))
                                , InfoServiceResponseDto.class
                );
    }
}
