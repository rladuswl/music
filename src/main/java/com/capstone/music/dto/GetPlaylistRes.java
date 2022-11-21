package com.capstone.music.dto;

import com.capstone.music.domain.Music;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetPlaylistRes {
    private Long playlist_id;
    private String name;
    private String image;
    private List<Music> musics;
}