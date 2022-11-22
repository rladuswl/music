package com.capstone.music.controller;

import com.capstone.music.dto.GetMypageResDTO;
import com.capstone.music.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    // 마이페이지
    @GetMapping("/user/{user_id}")
    public ResponseEntity<GetMypageResDTO> myPage(@PathVariable Long user_id) {
        GetMypageResDTO getMypageResDTO = userService.myPage(user_id);
        return new ResponseEntity<>(getMypageResDTO, HttpStatus.OK);
    }

    // 내 정보 수정
    @PatchMapping("/user/{user_id}")
    public ResponseEntity<String> updateMyPage(@PathVariable Long user_id) {
        userService.updateMyPage(user_id);
        return new ResponseEntity<>("내 정보 수정 완료", HttpStatus.OK);
    }

    // 회원 탈퇴
    @PatchMapping ("/user/out/{user_id}")
    public ResponseEntity<String> out(@PathVariable Long user_id) {
        userService.out(user_id);
        return new ResponseEntity<>("회원 탈퇴 완료", HttpStatus.OK);
    }
}
