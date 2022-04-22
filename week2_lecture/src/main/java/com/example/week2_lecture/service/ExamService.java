package com.example.week2_lecture.service;

import com.example.week2_lecture.dto.request.LectureRequestDto;
import reactor.core.publisher.Mono;

public interface ExamService {

    void registerContent(Mono<LectureRequestDto> lectureRequestDto);

    void registerExamContent(Mono<LectureRequestDto> lectureRequestDto);

    void registerExamScore(Mono<LectureRequestDto> lectureRequestDto);
}
