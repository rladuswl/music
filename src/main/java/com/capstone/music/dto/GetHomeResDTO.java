package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetHomeResDTO {
    private String username;
    private List<GetPlaylistResDTO> getPlaylistResDTOList;
}
