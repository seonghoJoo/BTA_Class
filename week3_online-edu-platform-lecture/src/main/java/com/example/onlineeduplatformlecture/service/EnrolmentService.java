package com.example.onlineeduplatformlecture.service;

import com.example.onlineeduplatformlecture.model.Enrolment;
import reactor.core.publisher.Mono;

public interface EnrolmentService {
    // POST /lectures/{lectureId}/enrolment (수강 신청)
    Mono<Enrolment> enrolmentLectuer(int lectureId);
}
