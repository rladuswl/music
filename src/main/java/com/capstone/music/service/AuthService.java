package com.capstone.music.service;

import com.capstone.music.config.S3Uploader;
import com.capstone.music.domain.Music;
import com.capstone.music.domain.User;
import com.capstone.music.dto.GetFeelingResDTO;
import com.capstone.music.dto.JoinReqDTO;
import com.capstone.music.dto.LoginReqDTO;
import com.capstone.music.dto.LoginResDTO;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final S3Uploader s3Uploader;

    public String join(MultipartFile multipartFile, String username, String password, String nickname, String introduce) throws IOException {
        String dirName = "user";
        String uploadImageUrl = s3Uploader.upload(multipartFile, dirName);

        User user = User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .profile(uploadImageUrl)
                .introduce(introduce)
                .status(true).build();

        userRepository.save(user);

        return "회원가입 완료";
    }

    public LoginResDTO login(LoginReqDTO loginReqDTO) throws IOException {
        User user = userRepository.findByUsername(loginReqDTO.getUsername());

        LoginResDTO loginResDTO = LoginResDTO.builder()
                .id(user.getId()).build();

        return loginResDTO;
    }
}
