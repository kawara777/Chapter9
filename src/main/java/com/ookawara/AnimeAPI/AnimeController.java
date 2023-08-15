package com.ookawara.AnimeAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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

}
