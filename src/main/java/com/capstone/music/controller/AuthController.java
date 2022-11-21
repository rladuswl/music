package com.capstone.music.controller;

import com.capstone.music.dto.JoinReqDTO;
import com.capstone.music.dto.LoginReqDTO;
import com.capstone.music.dto.LoginResDTO;
import com.capstone.music.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    // 회원가입
    @PostMapping("/join")
    public String join(@RequestBody JoinReqDTO joinReqDTO) {
        authService.join(joinReqDTO);
        return "회원가입 완료";
    }

    // 로그인
    @PostMapping ("/login")
    public LoginResDTO login(@RequestBody LoginReqDTO loginReqDTO) {
        LoginResDTO loginResDTO = authService.login(loginReqDTO);
        return loginResDTO;
    }

    // 회원 탈퇴
    @PostMapping ("/user/{user_id}")
    public void out(@PathVariable Long user_id) {
    }
}
