package com.capstone.music.service;

import com.capstone.music.domain.Music;
import com.capstone.music.domain.Playlist;
import com.capstone.music.domain.User;
import com.capstone.music.dto.GetFeelingResDTO;
import com.capstone.music.dto.GetHomeResDTO;
import com.capstone.music.dto.GetPlaylistResDTO;
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

    public GetHomeResDTO home(Long user_id) {
        Optional<User> user = userRepository.findById(user_id);
        List<Playlist> playlistList = playlistRepository.findByUserId(user_id);

        List<GetPlaylistResDTO> getPlaylistResDTOList = new ArrayList<>();
        for (Playlist p : playlistList) {
            GetPlaylistResDTO getPlaylistResDTO = GetPlaylistResDTO.builder()
                    .playlist_id(p.getId())
                    .name(p.getName())
                    .image(p.getImage())
                    .musics(null).build(); // home에서는 music 필요 x
            getPlaylistResDTOList.add(getPlaylistResDTO);
        }

        GetHomeResDTO getHomeResDTO = GetHomeResDTO.builder()
                .username(user.get().getUsername())
                .getPlaylistResDTOList(getPlaylistResDTOList).build();
        return getHomeResDTO;
    }

    public GetFeelingResDTO homeFeeling(Long user_id, String feeling) {
        List<Music> musicList = musicRepository.findByFeeling(feeling);
        int music_size = musicList.size();

        Random rand = new Random();
        int result = rand.nextInt(music_size);

        GetFeelingResDTO getFeelingRes = GetFeelingResDTO.builder()
                .title(musicList.get(result).getTitle())
                .file(musicList.get(result).getFile())
                .feeling(musicList.get(result).getFeeling()).build();

        return getFeelingRes;
    }
}
