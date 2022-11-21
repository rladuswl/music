package com.capstone.music.service;

import com.capstone.music.domain.Music;
import com.capstone.music.domain.MusicPlaylist;
import com.capstone.music.domain.Playlist;
import com.capstone.music.dto.GetPlaylistRes;
import com.capstone.music.repository.MusicPlaylistRepository;
import com.capstone.music.repository.PlaylistRepository;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MusicPlaylistRepository musicPlaylistRepository;

    public List<GetPlaylistRes> myPlaylist(Long user_id) {
        List<Playlist> playlistList = playlistRepository.findByUserId(user_id);
        List<GetPlaylistRes> getPlaylistResList = new ArrayList<>();

        for (Playlist p : playlistList) {
            List<MusicPlaylist> musicPlaylists = musicPlaylistRepository.findByPlaylistId(p.getId());
            List<Music> musicList = new ArrayList<>();

            for (MusicPlaylist mp : musicPlaylists) {
                musicList.add(mp.getMusic());
            }
            GetPlaylistRes getPlaylistRes = GetPlaylistRes.builder()
                    .playlist_id(p.getId())
                    .musics(musicList)
                    .name(p.getName())
                    .image(p.getImage()).build();
            getPlaylistResList.add(getPlaylistRes);
        }
    }

    public String newPlaylist(Long playlist_id) {

    }

    public String updatePlaylist(Long playlist_id) {

    }

    public String deletePlaylist(Long playlist_id) {

    }

    public String addPlaylist(Long playlist_id) {

    }

    public String deleteMusicInPlaylist(Long playlist_id) {

    }
}
