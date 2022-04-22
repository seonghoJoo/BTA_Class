package com.example.week2_lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grading {

    private Long id;
    private Integer score;
    private Timestamp regdate;
    private Long userId;
    private Long examId;
}
