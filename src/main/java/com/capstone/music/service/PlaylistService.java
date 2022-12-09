package com.capstone.music.service;

import com.capstone.music.config.S3Uploader;
import com.capstone.music.domain.Music;
import com.capstone.music.domain.MusicPlaylist;
import com.capstone.music.domain.Playlist;
import com.capstone.music.domain.User;
import com.capstone.music.dto.GetMusicResDTO;
import com.capstone.music.dto.GetPlaylistResDTO;
import com.capstone.music.repository.MusicPlaylistRepository;
import com.capstone.music.repository.MusicRepository;
import com.capstone.music.repository.PlaylistRepository;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final MusicRepository musicRepository;
    private final MusicPlaylistRepository musicPlaylistRepository;
    private final S3Uploader s3Uploader;

    public List<GetPlaylistResDTO> myPlaylists(Long user_id) {
        List<Playlist> playlistList = playlistRepository.findByUserId(user_id);
        List<GetPlaylistResDTO> getPlaylistResDTOList = new ArrayList<>();

        for (Playlist p : playlistList) {
            List<MusicPlaylist> musicPlaylists = musicPlaylistRepository.findByPlaylistId(p.getId());
            List<GetMusicResDTO> musicList = new ArrayList<>();

            for (MusicPlaylist mp : musicPlaylists) {
                GetMusicResDTO getMusicResDTO = GetMusicResDTO.builder()
                        .id(mp.getMusic().getId())
                        .title(mp.getMusic().getTitle())
                        .file(mp.getMusic().getFile())
                        .feeling(mp.getMusic().getFeeling()).build();
                musicList.add(getMusicResDTO);
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

    public GetPlaylistResDTO playlist(Long playlist_id, Long user_id) {
        Optional<Playlist> playlist = playlistRepository.findById(playlist_id);
        List<MusicPlaylist> musicPlaylistList = musicPlaylistRepository.findByPlaylistId(playlist_id);

        List<GetMusicResDTO> musicList = new ArrayList<>();
        for (MusicPlaylist mp: musicPlaylistList) {
            GetMusicResDTO getMusicResDTO = GetMusicResDTO.builder()
                    .id(mp.getMusic().getId())
                    .title(mp.getMusic().getTitle())
                    .file(mp.getMusic().getFile())
                    .feeling(mp.getMusic().getFeeling()).build();
            musicList.add(getMusicResDTO);
        }

        return GetPlaylistResDTO.builder()
                .playlist_id(playlist.get().getId())
                .name(playlist.get().getName())
                .image(playlist.get().getImage())
                .musics(musicList).build();
    }

    public Long newPlaylist(Long user_id, MultipartFile multipartFile, String name) throws IOException {
        Optional<User> user = userRepository.findById(user_id);
        String dirName = "playlist";
        String uploadImageUrl = s3Uploader.upload(multipartFile, dirName);

        Playlist playlist = Playlist.builder()
                .image(uploadImageUrl)
                .name(name)
                .user(user.get()).build();
        playlistRepository.save(playlist);
        return playlist.getId();
    }

    public String updatePlaylist(MultipartFile multipartFile, String name, Long playlist_id) throws IOException {
        Optional<Playlist> playlist = playlistRepository.findById(playlist_id);

        s3Uploader.deleteS3("playlist", playlist.get().getImage());
        String newImageUrl = s3Uploader.upload(multipartFile, "playlist");

        playlist.get().setName(name);
        playlist.get().setImage(newImageUrl);
        playlistRepository.save(playlist.get());

        return "playlist 수정 완료";
    }

    public String deletePlaylist(Long playlist_id) {
        Optional<Playlist> playlist = playlistRepository.findById(playlist_id);
        playlistRepository.delete(playlist.get());
        return "playlist 삭제 완료";
    }

    public String addPlaylist(Long playlist_id, Long music_id) {
        Optional<Playlist> playlist = playlistRepository.findById(playlist_id);
        Optional<Music> music = musicRepository.findById(music_id);

        MusicPlaylist musicPlaylist = MusicPlaylist.builder()
                .music(music.get())
                .playlist(playlist.get()).build();

        musicPlaylistRepository.save(musicPlaylist);

        return "플레이리스트에 노래 추가 완료";
    }

    public String deleteMusicInPlaylist(Long playlist_id, Long music_id) {
        MusicPlaylist musicPlaylist = musicPlaylistRepository.findByPlaylistIdAndMusicId(playlist_id, music_id);
        musicPlaylistRepository.delete(musicPlaylist);
        return "플레이리스트 내 노래 삭제 완료";
    }
}
