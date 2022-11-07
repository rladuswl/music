package com.capstone.music.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String profile;
    private String introduce;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Playlist> playlists;

    // 테스트 결과
   private String test_result;
}
