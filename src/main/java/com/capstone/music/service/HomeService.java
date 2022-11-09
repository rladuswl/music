package com.capstone.music.service;

import com.capstone.music.domain.User;
import com.capstone.music.dto.GetHomeRes;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final UserRepository userRepository;

    public GetHomeRes home(Long user_id) {
        User user = userRepository.findById(user_id);
        GetHomeRes getHomeRes = GetHomeRes.builder().build();
        return getHomeRes;
    }
}
