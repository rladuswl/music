package com.capstone.music.controller;

import com.capstone.music.dto.GetFeelingResDTO;
import com.capstone.music.dto.GetHomeResDTO;
import com.capstone.music.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class HomeController {

    private final HomeService homeService;

    // 홈 화면
    @GetMapping("/home/{user_id}")
    public GetHomeResDTO home(@PathVariable Long user_id) {
        GetHomeResDTO getHomeResDTO = homeService.home(user_id);
        return getHomeResDTO;
    }

    // 감정 선택
    @PostMapping("/home/{user_id}/feeling")
    public GetFeelingResDTO homeFeeling(@PathVariable Long user_id, @RequestParam("feeling") String f) {
        GetFeelingResDTO getFeelingRes = homeService.homeFeeling(user_id, f);
        return getFeelingRes;
    }

}
