package com.example.onlineeduplatformuser.handler;

import com.example.onlineeduplatformuser.dto.UserDto;
import com.example.onlineeduplatformuser.dto.UserLoginResponse;
import com.example.onlineeduplatformuser.dto.UserRegistrationResponse;
import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.model.UserType;
import com.example.onlineeduplatformuser.repository.UserRepository;
import com.example.onlineeduplatformuser.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebInputException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserHandler {

    private final Validator validator;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    // 강사 등록
    public Mono<ServerResponse> register(ServerRequest request) {
        Mono<UserDto> userDto = request.bodyToMono(UserDto.class).doOnNext(this::validate);
        return userDto
                .flatMap(user -> {
                    user.setUserType(String.valueOf(UserType.LECTURE));
                    return ok().body(userRepository.save(objectMapper.convertValue(user, User.class)),
                            UserRegistrationResponse.class);
                })
                .log();
    }

    // 학생 등록
    public Mono<ServerResponse> join(ServerRequest request) {
        Mono<UserDto> userDto = request.bodyToMono(UserDto.class).doOnNext(this::validate);
        return userDto
                .flatMap(user -> {
                    user.setUserType(String.valueOf(UserType.USER));
                    return ok().body(userRepository.save(objectMapper.convertValue(user, User.class)),
                            UserRegistrationResponse.class);
                })
                .log();
    }

    private void validate(Object object) {
        Errors errors = new BeanPropertyBindingResult(object, object.getClass().getName());
        validator.validate(object, errors);
        if (errors.hasErrors()) {
            throw new ServerWebInputException(errors.toString());
        }
    }

    public Mono<ServerResponse> login(ServerRequest serverRequest) {
        Mono<UserLoginResponse> user = serverRequest.bodyToMono(Map.class)
                .flatMap(userService::loginService)
                .log();

        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", "JWT");
        headers.put("alg", "HS256");

        // payload 부분 설정
        Map<String, Object> payloads = new HashMap<>();

        Long expiredTime = 1000 * 60L * 60L * 1L; // 토큰 유효 시간 (2시간)
        Date date = new Date(); // 토큰 만료 시간
        date.setTime(date.getTime() + expiredTime);

        Key key = Keys.hmacShaKeyFor(
                "MyNickNameisErjuerAndNameisMinsu".getBytes(StandardCharsets.UTF_8));

        final Mono<String> tokkens = user.map(mapper -> {
            System.out.println("++++++++++++" + mapper.getUserType());
            payloads.put("typ", mapper.getUserType());
            payloads.put("id", mapper.getUserId());
            payloads.put("exp", date);
            // 토큰 Builder
            String jwt = "Bearer " + Jwts.builder()
                    .setHeader(headers) // Headers 설정
                    .setClaims(payloads) // Claims 설정
                    .setExpiration(date) // 토큰 만료 시간 설정
                    .signWith(key, SignatureAlgorithm.HS256)
                    .compact();
            System.out.println(jwt);
            return jwt;
        });
        return tokkens.flatMap(value -> ServerResponse.ok()
                .header("Authorization", value)
                .body(user.map(mapper -> mapper.getUserType()), String.class));

    }
}
