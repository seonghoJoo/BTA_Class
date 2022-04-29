package com.example.onlineeduplatformuser.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rating {

    private Long ratingId;
    private Long lectureId;
    private Long userId;
    private Double rating;
    private String comment;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
