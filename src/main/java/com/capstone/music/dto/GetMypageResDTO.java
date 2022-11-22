package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetMypageResDTO {
    private String nickname;
    private String profile;
    private String introduce;
    private String test_result;
}
