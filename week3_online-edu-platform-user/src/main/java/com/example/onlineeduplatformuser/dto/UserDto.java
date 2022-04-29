package com.example.onlineeduplatformuser.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String userType;
    private String name;
    private String email;
    private String password;
    private String address;
    private String phone;
}
