package com.sparta.springproject4week.dto;

import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String title;
    private String name;
    private String password;
    private String content;
}