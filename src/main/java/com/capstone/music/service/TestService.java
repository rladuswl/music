package com.capstone.music.service;

import com.capstone.music.dto.PostTestAnswersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {

    public String test(Long user_id, PostTestAnswersDTO postTestAnswersDTO) {
        // 대답에 따라 경우의 수 만들기 -> 결과 결정하기

        String result = null;

        return result;
    }
}
