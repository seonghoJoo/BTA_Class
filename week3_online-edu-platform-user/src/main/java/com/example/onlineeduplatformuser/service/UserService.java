package com.example.onlineeduplatformuser.service;

import com.example.onlineeduplatformuser.dto.UserLoginResponse;
import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.model.UserType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface UserService {
    // UserRegistrationResponse registrationTeacher(ServerRequest serverRequest);
    //
    // UserRegistrationResponse registrationStudent(ServerRequest serverRequest);
    //
    Mono<UserLoginResponse> loginService(Map<String, Object> param);

}
