package com.example.week2_lecture.controller;

import com.example.week2_lecture.domain.UserRole;
import com.example.week2_lecture.dto.request.LectureRequestDto;
import com.example.week2_lecture.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ExamHandler {

    @Autowired
    ExamService examService;


    @Secured(value = UserRole.Authority.LECTURER)
    public Mono<ServerResponse> registerExamContent(ServerRequest request) {
        Mono<LectureRequestDto> lectureRequestDto = request.bodyToMono(LectureRequestDto.class);
        examService.registerExamContent(lectureRequestDto);
        return null;
    }

    @Secured(value = UserRole.Authority.LECTURER)
    public Mono<ServerResponse> writeExamScore(ServerRequest request) {
        Mono<LectureRequestDto> lectureRequestDto = request.bodyToMono(LectureRequestDto.class);
        examService.registerExamScore(lectureRequestDto);
        return null;
    }
}
