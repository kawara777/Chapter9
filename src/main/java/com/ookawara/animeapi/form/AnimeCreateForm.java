package com.ookawara.animeapi.form;

public class AnimeCreateForm {
    private String name;
    private int episode;

    public AnimeCreateForm(String name, int episode) {
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
