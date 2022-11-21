package com.capstone.music.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetFeelingResDTO {
    private String title;
    private String file;
    private String feeling;
}
