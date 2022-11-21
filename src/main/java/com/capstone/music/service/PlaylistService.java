package com.capstone.music.service;

import com.capstone.music.domain.Music;
import com.capstone.music.domain.MusicPlaylist;
import com.capstone.music.domain.Playlist;
import com.capstone.music.dto.GetPlaylistResDTO;
import com.capstone.music.repository.MusicPlaylistRepository;
import com.capstone.music.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final MusicPlaylistRepository musicPlaylistRepository;

    public List<GetPlaylistResDTO> myPlaylists(Long user_id) {
        List<Playlist> playlistList = playlistRepository.findByUserId(user_id);
        List<GetPlaylistResDTO> getPlaylistResDTOList = new ArrayList<>();

        for (Playlist p : playlistList) {
            List<MusicPlaylist> musicPlaylists = musicPlaylistRepository.findByPlaylistId(p.getId());
            List<Music> musicList = new ArrayList<>();

            for (MusicPlaylist mp : musicPlaylists) {
                musicList.add(mp.getMusic());
            }
            GetPlaylistResDTO getPlaylistResDTO = GetPlaylistResDTO.builder()
                    .playlist_id(p.getId())
                    .musics(musicList)
                    .name(p.getName())
                    .image(p.getImage()).build();
            getPlaylistResDTOList.add(getPlaylistResDTO);
        }
        return getPlaylistResDTOList;
    }

    public GetPlaylistResDTO myPlaylist(Long playlist_id, Long user_id) {
        Optional<Playlist> playlist = playlistRepository.findById(playlist_id);
        List<MusicPlaylist> musicPlaylistList = musicPlaylistRepository.findByPlaylistId(playlist_id);

        List<Music> musicList = new ArrayList<>();
        for (MusicPlaylist mp: musicPlaylistList) {
            musicList.add(mp.getMusic());
        }

        return GetPlaylistResDTO.builder()
                .name(playlist.get().getName())
                .image(playlist.get().getImage())
                .musics(musicList).build();
    }

    public String newPlaylist() {

    }

    public String updatePlaylist(Long playlist_id) {

    }

    public String deletePlaylist(Long playlist_id) {

    }

    public String addPlaylist(Long playlist_id) {

    }

    public String deleteMusicInPlaylist(Long playlist_id, Long music_id) {

    }
}
