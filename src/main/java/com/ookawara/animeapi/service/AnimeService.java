package com.ookawara.animeapi.service;

import com.ookawara.animeapi.entity.Anime;

import java.util.List;
import java.util.Optional;

public interface AnimeService {

    List<Anime> findAll();

    Optional<Anime> findById(int id);

    List<Anime> findUpToEpisode(int episode);

    Anime createAnimeData(String name, int episode);

    void updateAnimeData(int id, String name, int episode);

    void deleteById(int id);
}
