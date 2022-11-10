package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetPlaylistRes {
    private Long playlist_id;
    private String name;
    private String image;
    private List<String> musics;
}