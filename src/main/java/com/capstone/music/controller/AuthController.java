package com.capstone.music.controller;

import com.capstone.music.dto.JoinReqDTO;
import com.capstone.music.dto.LoginReqDTO;
import com.capstone.music.dto.LoginResDTO;
import com.capstone.music.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestPart MultipartFile multipartFile, @RequestBody JoinReqDTO joinReqDTO) throws IOException {
        authService.join(multipartFile, joinReqDTO);
        return new ResponseEntity<>("회원가입 완료", HttpStatus.OK);
    }

    // 로그인
    @PostMapping ("/login")
    public ResponseEntity<LoginResDTO> login(@RequestBody LoginReqDTO loginReqDTO) throws IOException {
        LoginResDTO loginResDTO = authService.login(loginReqDTO);
        return new ResponseEntity<>(loginResDTO, HttpStatus.OK);

    }
}
