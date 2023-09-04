package com.ookawara.animeapi.service;

import com.ookawara.animeapi.entity.Anime;

import java.util.List;

public interface AnimeService {

    List<Anime> findAll();

    Anime findById(int id) throws Exception;
    List<Anime> findUpToEpisode(int episode);

    Anime createAnimeData(String name, int episode);

    void updateAnimeData(int id, String name, int episode) throws Exception;

    void deleteById(int id);
}
