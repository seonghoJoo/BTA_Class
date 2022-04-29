package com.example.onlineeduplatformlecture.model;


import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rating {

    @Id
    private Long ratingId;
    private Long lectureId;
    private Long userId;
    private Double rating;
    private String comment;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Rating(Long lectureId, Long userId, Double rating, String comment) {
        this.lectureId = lectureId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
    }
}
