package com.capstone.music.service;

import com.capstone.music.domain.Music;
import com.capstone.music.domain.Playlist;
import com.capstone.music.domain.User;
import com.capstone.music.dto.GetFeelingRes;
import com.capstone.music.dto.GetHomeRes;
import com.capstone.music.dto.GetPlaylistRes;
import com.capstone.music.repository.MusicRepository;
import com.capstone.music.repository.PlaylistRepository;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final UserRepository userRepository;
    private final PlaylistRepository playlistRepository;
    private final MusicRepository musicRepository;

    public GetHomeRes home(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        List<Playlist> playlistList = playlistRepository.findByUserId(user_id);

        List<GetPlaylistRes> getPlaylistResList = new ArrayList<>();
        for (Playlist p : playlistList) {
            GetPlaylistRes getPlaylistRes = GetPlaylistRes.builder()
                    .playlist_id(p.getId())
                    .name(p.getName())
                    .image(p.getImage())
                    .musics(null).build(); // home에서는 music 필요 x
            getPlaylistResList.add(getPlaylistRes);
        }

        GetHomeRes getHomeRes = GetHomeRes.builder()
                .username(user.get().getUsername())
                .getPlaylistResList(getPlaylistResList).build();
        return getHomeRes;
    }

    public GetFeelingRes homeFeeling(Long user_id, String feeling) {
        List<Music> musicList = musicRepository.findByFeeling(feeling);
        int music_size = musicList.size();

        Random rand = new Random();
        int result = rand.nextInt(music_size);

        GetFeelingRes getFeelingRes = GetFeelingRes.builder()
                .title(musicList.get(result).getTitle())
                .file(musicList.get(result).getFile())
                .feeling(musicList.get(result).getFeeling()).build();

        return getFeelingRes;
    }
}
