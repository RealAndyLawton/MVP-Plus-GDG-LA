package com.realandylawton.mvpplus.repository;

import com.realandylawton.mvpplus.model.Pokemon;

import rx.Observable;

/**
 * Created by andylawton on 7/28/16.
 */
public interface PokedexRepository {
    Observable<Pokemon> getPokemon(String pokemonId);
}
