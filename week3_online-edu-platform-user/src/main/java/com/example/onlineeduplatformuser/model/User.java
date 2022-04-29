package com.example.onlineeduplatformuser.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column("userId")
    private Long userId;

    @Column("userType")
    private String  userType;

    @Column("name")
    private String name;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("address")
    private String address;

    @Column("phone")
    private String phone;

    // public User(int userId, int userType, String name, String email, String
    // password, String address,
    // String phone) {
    // this.userId = userId;
    // this.userType = userType;
    // this.name = name;
    // this.email = email;
    // this.password = password;
    // this.address = address;
    // this.phone = phone;
    // }
    //
    // public int getUserId() {
    // return userId;
    // }
    //
    // public int getUserType() {
    // return userType;
    // }
    //
    // public String getName() {
    // return name;
    // }
    //
    // public String getEmail() {
    // return email;
    // }
    //
    // public String getPassword() {
    // return password;
    // }
    //
    // public String getAddress() {
    // return address;
    // }
    //
    // public String getPhone() {
    // return phone;
    // }

}
