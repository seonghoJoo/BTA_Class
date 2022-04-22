package com.example.week2_lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    private Long id;
    private String title;
    private String content;

    //@MappedBy
    private Long lecture_id;

}
