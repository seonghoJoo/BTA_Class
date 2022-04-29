package com.example.onlineeduplatformuser.model;

public enum UserType {
    USER (1), LECTURE(2), ADMIN(9);

    UserType(int typeValue) {
        this.value = String.valueOf(typeValue);
    }

    private final String value;

    public String getValue() {
        return this.value;
    }
}
