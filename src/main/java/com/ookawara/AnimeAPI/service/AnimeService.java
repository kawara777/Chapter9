package com.ookawara.AnimeAPI.service;

import com.ookawara.AnimeAPI.entity.Anime;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AnimeService {

    List<Anime> findAll();

    Optional<Anime> findById(int id);

    List<Anime> findUpToEpisode(int episode);

    Anime createAnimeData(String name, int episode);
}
