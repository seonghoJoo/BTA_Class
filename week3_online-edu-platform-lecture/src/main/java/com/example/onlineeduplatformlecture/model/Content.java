package com.example.onlineeduplatformlecture.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table(value = "CONTENT")
public class Content {

    @Id
    @Column(value = "content_id")
    private final int contentId;

    @Column(value = "lecture_id")
    private final int lectureId;
    @Column(value = "cotent")
    private final String content;
    private final boolean examYn;

    @CreatedDate
    LocalDateTime createdAt;

    @LastModifiedDate
    LocalDateTime updatedAt;
    public Content(int contentId, int lectureId, String content, boolean examYn) {
        this.contentId = contentId;
        this.lectureId = lectureId;
        this.content = content;
        this.examYn = examYn;
    }

    public int getContentId() {
        return contentId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public String getContent() {
        return content;
    }

    public boolean isExamYn() {
        return examYn;
    }
}
