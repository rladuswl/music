package com.capstone.music.service;

import com.capstone.music.domain.User;
import com.capstone.music.dto.GetMypageResDTO;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public GetMypageResDTO myPage(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);

        GetMypageResDTO getMypageResDTO = GetMypageResDTO.builder()
                .nickname(user.get().getNickname())
                .profile(user.get().getProfile())
                .introduce(user.get().getIntroduce())
                .test_result(user.get().getTest_result()).build();

        return getMypageResDTO;
    }

    public String updateMyPage(Long user_id) {
        return "내 정보 수정 완료";
    }

    public String out(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        user.get().setStatus(false);
        return "회원 탈퇴 완료";
    }
}
