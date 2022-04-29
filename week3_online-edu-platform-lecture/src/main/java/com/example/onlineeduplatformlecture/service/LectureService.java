package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Lecture;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LectureService {

    // GET /lectures (강의 리스트 조회)
    Flux<Lecture> getLectureList();

    // GET /lectures/{lectureId} (강의 열람)
    Mono<Lecture> getLecture(int lectureId);


}
