package com.capstone.music.controller;

import com.capstone.music.dto.GetHomeRes;
import com.capstone.music.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    // 홈 화면
    @GetMapping("/home/{user_id}")
    public GetHomeRes home(@PathVariable Long user_id) {
        GetHomeRes getHomeRes = homeService.home(user_id);
        return getHomeRes;
    }

    // 감정 선택
}
