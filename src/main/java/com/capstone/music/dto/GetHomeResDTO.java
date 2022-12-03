package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class GetHomeResDTO {
    private String nickname;
    private List<GetPlaylistResDTO> getPlaylistResDTOList;
}
