package com.example.onlineeduplatformlecture.model;

public class Score {

    private final int scoreId;
    private final int lectureId;
    private final int userId;
    private final String score;
    private final String comment;

    public Score(int scoreId, int lectureId, int userId, String score, String comment) {
        this.scoreId = scoreId;
        this.lectureId = lectureId;
        this.userId = userId;
        this.score = score;
        this.comment = comment;
    }

    public int getScoreId() {
        return scoreId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getUserId() {
        return userId;
    }

    public String getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }
}
