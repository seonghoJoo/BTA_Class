package com.example.week2_community.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LectureResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long lectureId;
    private Timestamp regdate;
    private int rate;

}
