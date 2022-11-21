package com.capstone.music.controller;

import com.capstone.music.dto.GetPlaylistResDTO;
import com.capstone.music.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    // 내 플레이리스트
    @GetMapping("/playlist/user/{user_id}")
    public List<GetPlaylistResDTO> myPlaylists(@PathVariable Long user_id) {
        List<GetPlaylistResDTO> getPlaylistResDTOList = playlistService.myPlaylists(user_id);
        return getPlaylistResDTOList;
    }

    // 개별 플레이리스트
    @GetMapping("/playlist/{playlist_id}/user/{user_id}")
    public GetPlaylistResDTO myPlaylist(@PathVariable Long playlist_id, @PathVariable Long user_id) {
        GetPlaylistResDTO getPlaylistResDTO = playlistService.myPlaylist(playlist_id, user_id);

        return getPlaylistResDTO;
    }

    // 플레이리스트 생성
    @PostMapping ("/playlist/new")
    public void newPlaylist() {
        playlistService.newPlaylist();
    }

    // 플레이리스트 수정
    @PatchMapping("/playlist/{playlist_id}")
    public void updatePlaylist(@PathVariable Long playlist_id) {
        playlistService.updatePlaylist(playlist_id);
    }

    // 플레이리스트 삭제
    @DeleteMapping ("/playlist/{playlist_id}")
    public void deletePlaylist(@PathVariable Long playlist_id) {
        playlistService.deletePlaylist(playlist_id);
    }

    // 플레이리스트 추가
    @PostMapping ("/playlist/{playlist_id}/music/{music_id}")
    public void addPlaylist(@PathVariable Long playlist_id, @PathVariable Long music_id) {
        playlistService.addPlaylist(playlist_id);
    }

    // 플레이리스트에 추가된 노래 삭제
    @DeleteMapping("/playlist/{playlist_id}/music/{music_id}")
    public void deleteMusicInPlaylist(@PathVariable Long playlist_id, @PathVariable Long music_id) {
        playlistService.deleteMusicInPlaylist(playlist_id, music_id);
    }
}
