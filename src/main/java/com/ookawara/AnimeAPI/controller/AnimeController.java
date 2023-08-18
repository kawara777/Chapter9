package com.ookawara.AnimeAPI.controller;

import com.ookawara.AnimeAPI.service.AnimeService;
import com.ookawara.AnimeAPI.entity.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/anime")
public class AnimeController {

public AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public List<AnimeResponse> anime(){
        List<Anime> anime = animeService.findAll();
        List<AnimeResponse> responses = anime.stream().map(anime1 -> new AnimeResponse(anime1.getName(), anime1.getEpisode())).toList();
        return responses;
    }

    @GetMapping("/{id}")
    public List<AnimeResponse> findById (@PathVariable int id) {
        Optional<Anime> anime = animeService.findById(id);
        List<AnimeResponse> responses = anime.stream().map(anime1 -> new AnimeResponse(anime1.getName(), anime1.getEpisode())).toList();

            return responses;
    }

    @GetMapping("/episodes")
    public List<AnimeResponse> findByEpisodes(@RequestParam("episodes") int episode){
        List<Anime> anime = animeService.findByEpisodes(episode);
        List<AnimeResponse> responses = anime.stream().map(anime1 -> new AnimeResponse(anime1.getName(), anime1.getEpisode())).toList();
        return responses;
    }

}
