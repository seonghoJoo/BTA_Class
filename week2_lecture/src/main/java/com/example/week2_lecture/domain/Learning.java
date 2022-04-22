package com.example.week2_lecture.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Learning {

    private Long id;
    private Long userId;
    private Integer rate;

    //@MappedBy
    private Long lectureId;
}
