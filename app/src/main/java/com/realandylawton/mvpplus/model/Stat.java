package com.realandylawton.mvpplus.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by andylawton on 7/28/16.
 */
public class Stat {

    public static class Meta {
        @SerializedName("name") private String name;

        public String getName() {
            return name;
        }
    }

    @SerializedName("stat") private Meta meta;
    @SerializedName("base_stat") private Integer baseStat;

    public Meta getMeta() {
        return meta;
    }

    public Integer getBaseStat() {
        return baseStat;
    }

}
