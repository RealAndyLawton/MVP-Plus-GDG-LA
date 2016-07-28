package com.realandylawton.mvpplus.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andylawton on 7/28/16.
 */
public class Pokemon {

    @SerializedName("name") private String name;
    @SerializedName("stats") private List<Stat> stats;
    @SerializedName("sprites") private Sprites sprites;

    public String getName() {
        return name;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public Sprites getSprites() {
        return sprites;
    }
}
