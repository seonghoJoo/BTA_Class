package com.example.week2_community.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplyRequestDto {

    private String contents;
    private Timestamp timestamp;

    private Long userId;
    private Long articleId;
}
