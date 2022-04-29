package com.example.onlineeduplatformuser.dto;

public class UserLoginResponse {
    private final String userId;
    private final String userType;

    public UserLoginResponse(String userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }
}
