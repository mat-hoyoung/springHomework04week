package com.sparta.springproject4week.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BoardListRequestDto {
    private String usernaem;
    private String title;
}
