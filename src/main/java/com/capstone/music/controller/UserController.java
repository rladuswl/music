package com.capstone.music.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    // 마이페이지
    @GetMapping("/user/{user_id}")
    public void myPage(@PathVariable Long user_id) {
    }

    // 내 정보 수정
    @PatchMapping("/user/{user_id}")
    public void updateMyPage(@PathVariable Long user_id) {
    }
}
