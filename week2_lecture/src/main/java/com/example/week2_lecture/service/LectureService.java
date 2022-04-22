package com.example.week2_lecture.service;

import com.example.week2_lecture.dto.request.LectureRequestDto;
import com.example.week2_lecture.dto.request.UserRequestDto;
import reactor.core.publisher.Mono;

public interface LectureService {
    void registerLecture(LectureRequestDto lectureRequestDto);

    void rating(LectureRequestDto lectureRequestDto);

    void showLecture(Long lectureId);

    Object getRate(Mono<LectureRequestDto> lectureRequestDto);

    Object getListLecture(Mono<UserRequestDto> user);

    void registerLecture(Mono<LectureRequestDto> lectureRequestDto);

    void registerContent(Mono<LectureRequestDto> lectureRequestDto);
}
