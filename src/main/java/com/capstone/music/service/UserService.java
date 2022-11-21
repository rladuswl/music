package com.capstone.music.service;

import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public String myPage(Long user_id) {

    }

    public String updateMyPage(Long user_id) {

    }
}
