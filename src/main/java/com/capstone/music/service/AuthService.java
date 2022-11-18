package com.capstone.music.service;

import com.capstone.music.domain.Music;
import com.capstone.music.domain.User;
import com.capstone.music.dto.GetFeelingResDTO;
import com.capstone.music.dto.JoinReqDTO;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;

    public String join(JoinReqDTO joinReqDTO) {
        User user = User.builder()
                .username(joinReqDTO.getUsername())
                .password(joinReqDTO.getPassword())
                .nickname(joinReqDTO.getNickname())
                .profile(joinReqDTO.getProfile())
                .introduce(joinReqDTO.getIntroduce()).build();

        userRepository.save(user);

        return "회원가입 완료";
    }


}
