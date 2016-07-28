package com.realandylawton.mvpplus.repository;

import com.realandylawton.mvpplus.model.Pokemon;
import com.realandylawton.mvpplus.util.JsonAssetsLoader;

import java.util.concurrent.Callable;

import rx.Observable;

/**
 * Created by andylawton on 7/28/16.
 */
public class PokedexStubRespository implements PokedexRepository {

    private JsonAssetsLoader mAssetsLoader;

    public PokedexStubRespository(JsonAssetsLoader assetsLoader) {
        mAssetsLoader = assetsLoader;
    }

    @Override
    public Observable<Pokemon> getPokemon(String pokemonId) {
        return Observable.fromCallable(new Callable<Pokemon>() {
            @Override
            public Pokemon call() throws Exception {
                return mAssetsLoader.parseFromJsonFile("charizard.json", Pokemon.class);
            }
        });
    }
}
