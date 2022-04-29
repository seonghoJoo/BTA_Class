package com.example.onlineeduplatformlecture.repository;

import com.example.onlineeduplatformlecture.model.Lecture;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface LectureRepository extends ReactiveCrudRepository<Lecture, Long> {
    Mono<Lecture> findByLectureId(int lectuerId);

}
