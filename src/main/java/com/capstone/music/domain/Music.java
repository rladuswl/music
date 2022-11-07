package com.capstone.music.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Music {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String file;
    private String feeling;

    @OneToMany(mappedBy = "music")
    private List<MusicPlaylist> musicPlaylists = new ArrayList<>();
}
