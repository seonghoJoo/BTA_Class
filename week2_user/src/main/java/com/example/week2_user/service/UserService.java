package com.example.week2_user.service;

import com.example.week2_user.dto.request.UserRequestDto;
import com.example.week2_user.dto.response.LectureResponseDto;
import com.example.week2_user.dto.response.UserResponseDto;
import reactor.core.publisher.Mono;

public interface UserService {

    public Mono<UserResponseDto> userRegister(UserRequestDto userRequestDto);
    public Mono<UserResponseDto> adminRegister(UserRequestDto userRequestDto);
}
