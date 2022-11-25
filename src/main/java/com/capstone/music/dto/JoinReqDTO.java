package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JoinReqDTO {
    private String username;
    private String password;
    private String nickname;
    private String introduce;
}
