package com.realandylawton.mvpplus.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andylawton on 7/28/16.
 */
public class Sprites {

    @SerializedName("front_shiny") private String frontShiny;
    @SerializedName("back_shiny") private String backShiny;

    public String getFrontShiny() {
        return frontShiny;
    }

    public String getBackShiny() {
        return backShiny;
    }
}
