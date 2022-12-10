package com.capstone.music.service;

import com.capstone.music.domain.User;
import com.capstone.music.dto.PostTestAnswersDTO;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TestService {

    private final UserRepository userRepository;

    public String test(Long user_id, PostTestAnswersDTO postTestAnswersDTO) {
        // 대답에 따라 경우의 수 만들기 -> 결과 결정하기
        String result;

        List<String> answers = new ArrayList<>();
        answers.add(postTestAnswersDTO.getA1());
        answers.add(postTestAnswersDTO.getA2());
        answers.add(postTestAnswersDTO.getA3());
        answers.add(postTestAnswersDTO.getA4());
        answers.add(postTestAnswersDTO.getA5());

        int yes = 0;
        int no = 0;
        for(String s : answers) {
            if (Objects.equals(s, "yes")) {
                yes += 1;
            } else {
                no += 1;
            }
        }

        System.out.println("yes  " + yes);
        System.out.println("no  " + no);

        if (yes<=1) {
            result = "스트레스 지수가 낮아요";
        } else if (yes<=3) {
            result = "스트레스 지수가 꽤 높아요";
        } else {
            result = "스트레스 지수가 매우 높아요";
        }

        Optional<User> user = userRepository.findById(user_id);
        user.get().setTest_result(result);
        userRepository.save(user.get());

        return result;
    }
}
