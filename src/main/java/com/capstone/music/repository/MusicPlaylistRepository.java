package com.capstone.music.repository;

import com.capstone.music.domain.Music;
import com.capstone.music.domain.MusicPlaylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicPlaylistRepository extends JpaRepository<MusicPlaylist, Long> {
    List<MusicPlaylist> findByPlaylistId(Long playlist_id);

    MusicPlaylist findByPlaylistIdAndMusicId(Long playlist_id, Long music_id);
}
