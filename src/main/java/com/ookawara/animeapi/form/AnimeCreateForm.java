package com.ookawara.animeapi.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AnimeCreateForm {
    @NotBlank
    private String name;
    @Min(1)
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
