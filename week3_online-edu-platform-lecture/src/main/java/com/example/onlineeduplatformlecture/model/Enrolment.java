package com.example.onlineeduplatformlecture.model;

import lombok.Data;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table(value = "ENROLLMENT")
public class Enrolment {

    @Id
    @Column(value = "enrollment_id")
    private final int enrolmentId;
    @Column(value = "lecture_id")
    private final int lectureId;

    @Column(value = "user_id")
    private final int userId;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

}
