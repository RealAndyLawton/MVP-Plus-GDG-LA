package com.realandylawton.mvpplus.target;

import com.realandylawton.mvpplus.model.Stat;
import com.realandylawton.mvpplus.viewmodel.PokemonMetaViewModel;
import com.realandylawton.mvpplus.viewmodel.StatItemViewModel;

import java.util.List;

/**
 * Created by andylawton on 7/28/16.
 */
public interface PokemonTarget {
    void showPokemonMeta(PokemonMetaViewModel viewModel);
    void showStats(List<StatItemViewModel> stats);
    void showFailedToLoadPokemonError();
}
