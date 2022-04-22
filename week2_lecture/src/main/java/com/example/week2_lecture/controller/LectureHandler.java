package com.example.week2_lecture.controller;

import com.example.week2_lecture.domain.UserRole;
import com.example.week2_lecture.dto.request.LectureRequestDto;
import com.example.week2_lecture.dto.request.UserRequestDto;
import com.example.week2_lecture.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class LectureHandler {

    @Autowired
    LectureService lectureService;

    Long studentId = 1L;

    //수강신청 - 학생
    @Secured(value = UserRole.Authority.STUDENT)
    public Mono<ServerResponse> registerLectureByStudent(ServerRequest request) {
        Long lectureId = Long.parseLong(request.pathVariable("lectureId"));
        Mono<UserRequestDto> user = request.bodyToMono(UserRequestDto.class);
        LectureRequestDto lectureRequestDto = new LectureRequestDto(lectureId,studentId);

        lectureService.registerLecture(lectureRequestDto);

        return null;
    }
    // 별점 남기기 - 학생
    @Secured(value = UserRole.Authority.STUDENT)
    public Mono<ServerResponse> rating(ServerRequest request) {
        Long lectureId = Long.parseLong(request.pathVariable("lectureId"));
        Long ratingId = Long.parseLong(request.pathVariable("ratingId"));
        Mono<Integer> rate = request.bodyToMono(Integer.class);
        LectureRequestDto lectureRequestDto = new LectureRequestDto(lectureId,studentId,ratingId, rate.toFuture().getNow(0));

        lectureService.rating(lectureRequestDto);
        return null;
    }

    @Secured(value = UserRole.Authority.STUDENT)
    public Mono<ServerResponse> getListLectureByStudent(ServerRequest request) {
        Mono<UserRequestDto> user = request.bodyToMono(UserRequestDto.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(lectureService.getListLecture(user));
    }

    // 강의등록 - Admin
    @Secured(value = UserRole.Authority.ADMIN)
    public Mono<ServerResponse> registerLectureByAdmin(ServerRequest request) {
        Mono<LectureRequestDto> lectureRequestDto = request.bodyToMono(LectureRequestDto.class);
        lectureService.registerLecture(lectureRequestDto);
        return null;
    }

    // 강의 노출 - Admin
    @Secured(value = UserRole.Authority.ADMIN)
    public Mono<ServerResponse> showLecture(ServerRequest request) {
        Long lectureId = Long.parseLong(request.pathVariable("lectureId"));
        Mono<LectureRequestDto> lectureRequestDto = request.bodyToMono(LectureRequestDto.class);
        lectureService.showLecture(lectureId);
        return null;
    }

    //
    @Secured(value = UserRole.Authority.ADMIN)
    public Mono<ServerResponse> showLectureRate(ServerRequest request) {
        Long lectureId = Long.parseLong(request.pathVariable("lectureId"));
        Mono<LectureRequestDto> lectureRequestDto = request.bodyToMono(LectureRequestDto.class);
        lectureService.showLecture(lectureId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(lectureService.getRate(lectureRequestDto));
    }

    @Secured(value = UserRole.Authority.LECTURER)
    public Mono<ServerResponse> registerContent(ServerRequest request) {
        Mono<LectureRequestDto> lectureRequestDto = request.bodyToMono(LectureRequestDto.class);
        lectureService.registerContent(lectureRequestDto);
        return null;
    }

    @Secured(value = UserRole.Authority.LECTURER)
    public Mono<ServerResponse> getListLectureByLecturer(ServerRequest request) {
        Mono<UserRequestDto> user = request.bodyToMono(UserRequestDto.class);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(lectureService.getListLecture(user));
    }



}
