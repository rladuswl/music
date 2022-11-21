package com.capstone.music.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String file;
    private String feeling;

    @OneToMany(mappedBy = "music")
    private List<MusicPlaylist> musicPlaylists = new ArrayList<>();
}
