package com.realandylawton.mvpplus.component;

import com.realandylawton.mvpplus.activity.PokemonActivity;
import com.realandylawton.mvpplus.module.MVPPlusModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by andylawton on 7/28/16.
 */
@Singleton
@Component(modules = {MVPPlusModule.class})
public interface MVPPlusComponent {
    void inject(PokemonActivity pokemonActivity);
}
