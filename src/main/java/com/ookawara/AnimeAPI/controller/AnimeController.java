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
        List<Anime> animes = animeService.findAll();
        List<AnimeResponse> responses = animes.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();
        return responses;
    }

    @GetMapping("/{id}")
    public List<AnimeResponse> findById (@PathVariable int id) {
        Optional<Anime> animes = animeService.findById(id);
        List<AnimeResponse> responses = animes.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();

            return responses;
    }

    @GetMapping("/episodes")
    public List<AnimeResponse> findUpToEpisode(@RequestParam("episodes") int episode){
        List<Anime> animes = animeService.findUpToEpisode(episode);
        List<AnimeResponse> responses = animes.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();
        return responses;
    }

}
