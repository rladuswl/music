package com.capstone.music.service;

import com.capstone.music.domain.Music;
import com.capstone.music.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public String save(String uploadImageUrl, String feeling) {
        Music music = new Music();

        String title = "제목";

        if (feeling == "stressed") {
            title = "스트레스 하";
        } else if (feeling == "soStressed") {
            title = "스트레스 중";
        } else if (feeling == "superStressed") {
            title = "스트레스 상";
        }

        music.setTitle(title);
        music.setFile(uploadImageUrl);
        music.setFeeling(feeling);
        musicRepository.save(music);
        return "music file 저장 완료";
    }

}
