package com.example.onlineeduplatformlecture.model;

import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table(value = "LECTURE")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Lecture {

    @Id
    @Column(value = "lecture_id")
    private  int lectureId;

    @Column(value = "title")
    private  String title;
    @Column(value = "location")
    private  String location;
    @Column(value = "exposed_yn")
    private int exposedYn;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

}
