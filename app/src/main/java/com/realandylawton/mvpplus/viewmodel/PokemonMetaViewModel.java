package com.realandylawton.mvpplus.viewmodel;

import com.realandylawton.mvpplus.model.Pokemon;

/**
 * Created by andylawton on 7/28/16.
 */
public class PokemonMetaViewModel {

    public static PokemonMetaViewModel fromPokemon(Pokemon pokemon) {
        final PokemonMetaViewModel viewModel = new PokemonMetaViewModel();
        viewModel.mPokemon = pokemon;
        return viewModel;
    }

    private Pokemon mPokemon;

    public String getName() {
        final String name = mPokemon.getName();
        return Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }

    public String getFrontSpriteUrl() {
        return mPokemon.getSprites().getFrontShiny();
    }

    public String getBackSpriteUrl() {
        return mPokemon.getSprites().getBackShiny();
    }

}
