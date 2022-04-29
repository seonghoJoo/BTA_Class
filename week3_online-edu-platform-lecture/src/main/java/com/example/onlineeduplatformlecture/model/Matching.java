package com.example.onlineeduplatformlecture.model;

public class Matching {

    private final int matchingId;
    private final int lectureId;
    private final int userId;

    public Matching(int enrolmentId, int lectureId, int userId) {
        this.matchingId = enrolmentId;
        this.lectureId = lectureId;
        this.userId = userId;
    }

    public int getMatchingId() {
        return matchingId;
    }

    public int getLectureId() {
        return lectureId;
    }

    public int getUserId() {
        return userId;
    }

}
