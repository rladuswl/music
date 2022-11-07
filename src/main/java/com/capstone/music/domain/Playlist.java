package com.capstone.music.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Playlist {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "playlist")
    private List<MusicPlaylist> musicPlaylists = new ArrayList<>();
}
