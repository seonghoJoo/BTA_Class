package com.example.week2_community.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

    private Long id;
    private String contents;
    private Timestamp regdate;
    private char blur;

    private Long userId;
    private Long articleId;
}
