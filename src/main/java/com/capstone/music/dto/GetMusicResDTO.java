package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetMusicResDTO {
    private Long id;
    private String title;
    private String file;
    private String feeling;
}