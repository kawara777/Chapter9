package com.ookawara.AnimeAPI.controller;

import com.ookawara.AnimeAPI.AnimeUpdateForm;
import com.ookawara.AnimeAPI.form.AnimeCreateForm;
import com.ookawara.AnimeAPI.service.AnimeService;
import com.ookawara.AnimeAPI.entity.Anime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/anime")
public class AnimeController {

    public AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public List<AnimeResponse> anime() {
        List<Anime> animeList = animeService.findAll();
        List<AnimeResponse> responses = animeList.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();
        return responses;
    }

    @GetMapping("/{id}")
    public List<AnimeResponse> findById(@PathVariable int id) {
        Optional<Anime> animeList = animeService.findById(id);
        List<AnimeResponse> responses = animeList.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();
        return responses;
    }

    @GetMapping("/episodes")
    public List<AnimeResponse> findUpToEpisode(@RequestParam("episodes") int episode) {
        List<Anime> animeList = animeService.findUpToEpisode(episode);
        List<AnimeResponse> responses = animeList.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();
        return responses;
    }

    @PostMapping
    public ResponseEntity<Anime> createAnimeDate(@RequestBody AnimeCreateForm form, UriComponentsBuilder uriBuilder){
        Anime animeList = animeService.createAnimeData(form.getName(), form.getEpisode());
        URI url = uriBuilder
                .path("/anime/" + animeList.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(animeList);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String,String>> updateAnimeDate(@PathVariable int id, @RequestBody AnimeUpdateForm form){
        animeService.updateAnimeData(id,form.getName(),form.getEpisode());
        return ResponseEntity.ok(Map.of("massage","Anime successfully updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        animeService.deleteById(id);
        return ResponseEntity.ok("Anime data was successfully created");
    }
}
