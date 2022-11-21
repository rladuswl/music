package com.capstone.music.controller;

import com.capstone.music.config.S3Uploader;
import com.capstone.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
public class MusicController {
    private final S3Uploader s3Uploader;
    private final MusicService musicService;

    // AI -> Database로 노래 전송
    @PostMapping("/music/add")
    public ResponseEntity<String> addMusic(@RequestPart MultipartFile multipartFile, @RequestParam("feeling") String feeling) throws Exception {
        String dirName;

        if (feeling == "happy") {
            dirName = "happy";
        } else if (feeling == "sad") {
            dirName = "sad";
        } else if (feeling == "excited") {
            dirName = "excited";
        } else if (feeling == "love") {
            dirName = "love";
        } else if (feeling == "anger") {
            dirName = "anger";
        } else {
            dirName = "happy"; // 기본값
        }

        String uploadImageUrl = s3Uploader.upload(multipartFile, dirName);
        musicService.save(uploadImageUrl, dirName);
        return new ResponseEntity<String>("업로드 완료", HttpStatus.OK);
    }
}
