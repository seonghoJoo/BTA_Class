package com.example.week2_hello.resource.v2.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto{
    private String to;
    private String message;
    private String job;

    public void modMessage(String message){
        this.message = "hello " +  message;
    }
}