package com.capstone.music.domain;

import javax.persistence.*;

@Entity
public class MusicPlaylist {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "music_id")
    private Music music;
    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;
}
