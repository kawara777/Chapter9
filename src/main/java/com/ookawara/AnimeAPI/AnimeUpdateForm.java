package com.ookawara.AnimeAPI;

public class AnimeUpdateForm {
    private String name;
    private int episode;

    public AnimeUpdateForm(String name, int episode) {
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
