package com.example.week2_lecture.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
public class LectureRequestDto {
    private Long lectureId;
    private Long studentId;
    private Long ratingId;
    private Integer rate;

    private String title;
    private String content;
    private Timestamp regdate;
    private char blur;

    public LectureRequestDto(Long lectureId, Long studentId){
        this.lectureId = lectureId;
        this.studentId = studentId;
    }

    public LectureRequestDto(Long lectureId, Long studentId, Long ratingId, Integer rate){
        this.lectureId = lectureId;
        this.studentId = studentId;
        this.ratingId = ratingId;
        this.rate = rate;
    }



}
