package com.ookawara.animeapi.service;

import com.ookawara.animeapi.entity.Anime;
import com.ookawara.animeapi.exception.AnimeNotFoundException;
import com.ookawara.animeapi.mapper.AnimeMapper;
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
        Optional<Anime> anime = this.animeMapper.findById(id);
        if (anime.isPresent()){
            return Optional.of(anime.get());
        } else {
            throw new AnimeNotFoundException("ID:" + id + "のデータは存在しません。");
        }

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
    public void updateAnimeData(int id, String name, int episode) {
        Anime anime = animeMapper.findById(id).orElseThrow(() -> new AnimeNotFoundException("ID:" + id + "のデータは存在しません。"));
        animeMapper.updateAnimeData(anime);
    }

    @Override
    public void deleteById(int id){
        animeMapper.deleteById(id);
    }
}
