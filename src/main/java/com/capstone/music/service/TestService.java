package com.capstone.music.service;

import com.capstone.music.dto.PostTestAnswersDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TestService {

    public String test(Long user_id, PostTestAnswersDTO postTestAnswersDTO) {
        String result = null;
        return result;
    }
}
