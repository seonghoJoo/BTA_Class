package com.example.week2_user.controller;

import com.example.week2_user.domain.UserRole;
import com.example.week2_user.dto.request.UserRequestDto;
import com.example.week2_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    UserService userService;

    @Autowired
    WebClient webClient;

    Long studentId = 2L;

    @Secured(value = UserRole.Authority.STUDENT)
    public Mono<ServerResponse> register(ServerRequest request) {

        Mono<UserRequestDto> user = request.bodyToMono(UserRequestDto.class);
        return user.flatMap(u ->
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(userService .userRegister(u)));
    }

}
