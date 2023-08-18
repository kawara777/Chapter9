package com.ookawara.AnimeAPI.service;

import com.ookawara.AnimeAPI.entity.Anime;

import java.util.List;
import java.util.Optional;

public interface AnimeService {

    List<Anime> findAll();

    Optional<Anime> findById(int id);

    List<Anime> findByEpisodes(int episode);

}
