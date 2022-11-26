package com.capstone.music.controller;

import com.capstone.music.dto.JoinReqDTO;
import com.capstone.music.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    // 테스트 시작 + 결과 응답
    @PostMapping("/test/user/{user_id}")
    public ResponseEntity<> join(@PathVariable Long user_id) throws IOException {

        return new ResponseEntity<>(, HttpStatus.OK);
    }
}
