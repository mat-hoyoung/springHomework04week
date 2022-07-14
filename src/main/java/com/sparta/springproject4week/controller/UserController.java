package com.sparta.springproject4week.controller;

import com.sparta.springproject4week.dto.SignupRequestDto;
import com.sparta.springproject4week.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(com.sparta.springproject4week.service.UserService userService) {
        this.userService = userService;
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    // 회원 가입 요청 처리
    @PostMapping("/user/signup")
    public String registerUser(SignupRequestDto requestDto) {
        userService.registerUser(requestDto);
        return "redirect:/user/login";
    }
    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }


}