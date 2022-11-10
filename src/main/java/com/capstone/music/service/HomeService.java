package com.capstone.music.service;

import com.capstone.music.domain.Playlist;
import com.capstone.music.domain.User;
import com.capstone.music.dto.GetHomeRes;
import com.capstone.music.dto.GetPlaylistRes;
import com.capstone.music.repository.PlaylistRepository;
import com.capstone.music.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HomeService {

    private final UserRepository userRepository;
    private final PlaylistRepository playlistRepository;

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
}
