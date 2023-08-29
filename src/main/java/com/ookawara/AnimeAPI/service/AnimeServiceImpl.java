package com.ookawara.AnimeAPI.service;

import com.ookawara.AnimeAPI.entity.Anime;
import com.ookawara.AnimeAPI.mapper.AnimeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimeServiceImpl implements AnimeService{

    private AnimeMapper animeMapper;

    public AnimeServiceImpl(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }

    @Override
    public List<Anime> findAll(){
        return animeMapper.findAll();
    }

    @Override
    public Optional<Anime> findById(int id){
        return animeMapper.findById(id);
    }

    @Override
    public List<Anime> findUpToEpisode(int episode){
        return animeMapper.findUpToEpisode(episode);
    }

    @Override
    public Anime createAnimeData(String name, int episode){
        Anime anime = new Anime(name, episode);
        animeMapper.createAnimeData(anime);
        return anime;
    }

    @Override
    public void updateAnimeData(int id,String name,int episode){
        animeMapper.updateAnimeData(id,name,episode);
    }

    @Override
    public void deleteById(int id){
        animeMapper.deleteById(id);
    }
}
