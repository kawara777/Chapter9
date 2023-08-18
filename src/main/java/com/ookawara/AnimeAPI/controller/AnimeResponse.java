package com.ookawara.AnimeAPI.controller;

public class AnimeResponse {
    private String name;
    private int episode;

    public AnimeResponse(String name, int episode) {
        this.name = name;
        this.episode = episode;
    }

    public String getName() {
        return name;
    }

    public int getEpisode() {
        return episode;
    }
}
