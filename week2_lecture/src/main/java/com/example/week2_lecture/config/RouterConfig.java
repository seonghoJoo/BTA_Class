package com.example.week2_lecture.config;


import com.example.week2_lecture.controller.ExamHandler;
import com.example.week2_lecture.controller.LectureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class RouterConfig {

    //Router Function 모델
    @Bean
    public RouterFunction<ServerResponse> routerExample(LectureHandler lectureHandler, ExamHandler examHandler) {
        return RouterFunctions.route()
                // 강의
                // 학생 수강신청
                .POST("/lecture/{lectureId}", accept(APPLICATION_JSON), lectureHandler::registerLectureByStudent)
                // 학생 별점 남기기
                .POST("/rating/{lectureId}/{ratingId}", accept(APPLICATION_JSON), lectureHandler::rating)
                // 학생 강좌조회
                .GET("/lecture/learning/history", accept(APPLICATION_JSON), lectureHandler::getListLectureByStudent)
                // Admin 강의개설
                .POST("/lecture" , accept(APPLICATION_JSON), lectureHandler::registerLectureByAdmin)
                // Admin 강의 노출
                .PUT("/lecture/{lectureId}" , accept(APPLICATION_JSON), lectureHandler::showLecture)
                // Admin 강의 노출후 별점 열람
                .GET("/lecture/{lectureId}" , accept(APPLICATION_JSON), lectureHandler::showLectureRate)
                // 강사 콘텐츠업로드
                .PUT("/lecture/{lectureId}" , accept(APPLICATION_JSON), lectureHandler::registerContent)
                // 강사 과거강의 이력조회
                .GET("/lecture/teaching/history", accept(APPLICATION_JSON), lectureHandler::getListLectureByLecturer)
                // 시험 콘텐츠 추가
                .POST("/lecture/{lectureId}/exam" , accept(APPLICATION_JSON), examHandler::registerExamContent)
                // 시험 성적 입력
                .PUT("/lecture/{lectureId}/exam" , accept(APPLICATION_JSON), examHandler::writeExamScore)
                .build();
    }


}
