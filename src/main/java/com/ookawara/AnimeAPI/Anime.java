package com.ookawara.AnimeAPI;

public class Anime {

    private int id;
    private String name;

    public Anime(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
