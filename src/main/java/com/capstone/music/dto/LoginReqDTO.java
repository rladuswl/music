package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginReqDTO {
    private String username;
    private String password;
}
