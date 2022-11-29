package com.capstone.music.controller;

import com.capstone.music.dto.GetPlaylistResDTO;
import com.capstone.music.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class PlaylistController {

    private final PlaylistService playlistService;

    // 내 플레이리스트
    @GetMapping("/playlist/user/{user_id}")
    public ResponseEntity<List<GetPlaylistResDTO>> myPlaylists(@PathVariable Long user_id) {
        List<GetPlaylistResDTO> getPlaylistResDTOList = playlistService.myPlaylists(user_id);
        return new ResponseEntity<>(getPlaylistResDTOList, HttpStatus.OK);
    }

    // 개별 플레이리스트
    @GetMapping("/playlist/{playlist_id}/user/{user_id}")
    public ResponseEntity<GetPlaylistResDTO> playlist(@PathVariable Long playlist_id, @PathVariable Long user_id) {
        GetPlaylistResDTO getPlaylistResDTO = playlistService.playlist(playlist_id, user_id);
        return new ResponseEntity<>(getPlaylistResDTO, HttpStatus.OK);
    }

    // 플레이리스트 생성
    @PostMapping ("/playlist/new")
    public ResponseEntity<String> newPlaylist(@RequestPart("image") MultipartFile multipartFile, @RequestParam String name) throws IOException {

        return new ResponseEntity<>("new 플레이리스트 id : " + playlistService.newPlaylist(multipartFile, name), HttpStatus.OK);
    }

    // 플레이리스트 수정
    @PatchMapping("/playlist/{playlist_id}")
    public ResponseEntity<String> updatePlaylist(@RequestPart("image") MultipartFile multipartFile, @RequestParam String name, @PathVariable Long playlist_id) throws IOException {
        playlistService.updatePlaylist(multipartFile, name, playlist_id);
        return new ResponseEntity<>("플레이리스트 수정 완료", HttpStatus.OK);
    }

    // 플레이리스트 삭제
    @DeleteMapping ("/playlist/{playlist_id}")
    public ResponseEntity<String> deletePlaylist(@PathVariable Long playlist_id) {
        playlistService.deletePlaylist(playlist_id);
        return new ResponseEntity<>("플레이리스트 삭제 완료", HttpStatus.OK);
    }

    // 플레이리스트 추가
    @PostMapping ("/playlist/{playlist_id}/music/{music_id}")
    public ResponseEntity<String> addPlaylist(@PathVariable Long playlist_id, @PathVariable Long music_id) {
        playlistService.addPlaylist(playlist_id, music_id);
        return new ResponseEntity<>("플레이리스트 내 노래 추가 완료", HttpStatus.OK);
    }

    // 플레이리스트에 추가된 노래 삭제
    @DeleteMapping("/playlist/{playlist_id}/music/{music_id}")
    public ResponseEntity<String> deleteMusicInPlaylist(@PathVariable Long playlist_id, @PathVariable Long music_id) {
        playlistService.deleteMusicInPlaylist(playlist_id, music_id);
        return new ResponseEntity<>("플레이리스트 내 노래 삭제 완료", HttpStatus.OK);
    }
}
