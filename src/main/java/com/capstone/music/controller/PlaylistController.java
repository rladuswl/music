package com.capstone.music.controller;

import com.capstone.music.dto.GetPlaylistRes;
import com.capstone.music.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    // 내 플레이리스트
    @GetMapping("/playlist/{user_id}")
    public List<GetPlaylistRes> myPlaylist(@PathVariable Long user_id) {
        List<GetPlaylistRes> getPlaylistRes = playlistService.myPlaylist(user_id);
        return getPlaylistRes;
    }

    // 플레이리스트 생성
    @PostMapping ("/playlist/{playlist_id}")
    public void newPlaylist(@PathVariable Long playlist_id) {
    }

    // 플레이리스트 수정
    @PatchMapping("/playlist/{playlist_id}")
    public void updatePlaylist(@PathVariable Long playlist_id) {
    }

    // 플레이리스트 삭제
    @DeleteMapping ("/playlist/{playlist_id}")
    public void deletePlaylist(@PathVariable Long playlist_id) {
    }

    // 플레이리스트 추가
    @PostMapping ("/playlist/{playlist_id}/music/{music_id}")
    public void addPlaylist(@PathVariable Long playlist_id, @PathVariable Long music_id) {
    }

    // 플레이리스트에 추가된 노래 삭제
    @DeleteMapping("/playlist/{playlist_id}/music/{music_id}")
    public void deleteMusicInPlaylist(@PathVariable Long playlist_id, @PathVariable Long music_id) {
    }
}
