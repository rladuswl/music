package com.capstone.music.controller;

import com.capstone.music.dto.GetFeelingRes;
import com.capstone.music.dto.GetHomeRes;
import com.capstone.music.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/home/{user_id}/feeling")
    public GetFeelingRes homeFeeling(@PathVariable Long user_id, @RequestParam String f) {
        GetFeelingRes getFeelingRes = homeService.homeFeeling(user_id, f);
        return getFeelingRes;
    }

}
