package com.ookawara.AnimeAPI.entity;

public class Anime {

    private int id;
    private String name;
    private int episode;

    public Anime(int id, String name, int episode) {
        this.id = id;
        this.name = name;
        this.episode = episode;
    }

    public Anime(String name, int episode) {
        this.name = name;
        this.episode = episode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEpisode() {
        return episode;
    }
}
