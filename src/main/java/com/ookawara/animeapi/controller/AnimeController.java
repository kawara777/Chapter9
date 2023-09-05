package com.ookawara.animeapi.controller;

import com.ookawara.animeapi.entity.Anime;
import com.ookawara.animeapi.form.AnimeCreateForm;
import com.ookawara.animeapi.form.AnimeUpdateForm;
import com.ookawara.animeapi.service.AnimeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/anime")
public class AnimeController {

    public AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public List<Anime> anime() {
        return animeService.findAll();
    }

    @GetMapping("/{id}")
    public AnimeResponse findById(@PathVariable @Min(1) int id) throws Exception {
        Anime anime = animeService.findById(id);
        AnimeResponse animeResponse = new AnimeResponse(anime.getName(), anime.getEpisode());
        return animeResponse;
    }

    @GetMapping("/episodes")
    public List<AnimeResponse> findUpToEpisode(@RequestParam("episodes") @Min(12) int episode) {
        List<Anime> animeList = animeService.findUpToEpisode(episode);
        List<AnimeResponse> responses = animeList.stream().map(anime -> new AnimeResponse(anime.getName(), anime.getEpisode())).toList();
        return responses;
    }

    @PostMapping
    public ResponseEntity<Anime> createAnimeDate(@RequestBody @Valid AnimeCreateForm form, UriComponentsBuilder uriBuilder) {
        Anime animeList = animeService.createAnimeData(form.getName(), form.getEpisode());
        URI url = uriBuilder
                .path("/anime/" + animeList.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(animeList);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateAnimeDate(@PathVariable @Min(1) int id, @RequestBody @Valid AnimeUpdateForm form) throws Exception{
        animeService.updateAnimeData(id, form.getName(), form.getEpisode());
        return ResponseEntity.ok(Map.of("message", "Anime successfully updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable @Min(1) int id) {
        animeService.deleteById(id);
        return ResponseEntity.ok("Anime data was successfully deleted");
    }
}
