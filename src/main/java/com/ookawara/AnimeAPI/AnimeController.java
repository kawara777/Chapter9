package com.ookawara.AnimeAPI;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class AnimeController {

public AnimeMapper animeMapper;

    public AnimeController(AnimeMapper animeMapper) {
        this.animeMapper = animeMapper;
    }

    @GetMapping("/anime")
    public List<Anime> anime(){
        List<Anime> anime = animeMapper.findAll();
        return anime;
    }

    @GetMapping("/anime/{id}")
    public Optional<Anime> findById (@PathVariable int id){
        return animeMapper.findById(id);
    }

    @GetMapping("/anime-episode")
    public List<Anime> responseEpisodes(@RequestParam("episodes") int episode){
        return animeMapper.findByEpisodes(episode);
    }

}
