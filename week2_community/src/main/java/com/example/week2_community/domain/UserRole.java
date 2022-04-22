package com.example.week2_community.domain;

public enum UserRole {
    STUDENT(Authority.STUDENT),
    LECTURER(Authority.LECTURER),
    ADMIN(Authority.ADMIN);

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String STUDENT = "ROLE_STUDENT";
        public static final String LECTURER = "ROLE_LECTURER";
        public static final String ADMIN = "ROLE_ADMIN";
    }
}
