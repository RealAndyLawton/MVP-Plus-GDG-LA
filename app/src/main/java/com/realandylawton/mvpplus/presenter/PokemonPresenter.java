package com.realandylawton.mvpplus.presenter;

import com.realandylawton.mvpplus.model.Pokemon;
import com.realandylawton.mvpplus.model.Stat;
import com.realandylawton.mvpplus.repository.PokedexRepository;
import com.realandylawton.mvpplus.target.PokemonTarget;
import com.realandylawton.mvpplus.viewmodel.PokemonMetaViewModel;
import com.realandylawton.mvpplus.viewmodel.StatItemViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by andylawton on 7/28/16.
 */
public class PokemonPresenter extends Presenter<PokemonTarget> {

    private final PokedexRepository mPokedexRepository;

    @Inject
    public PokemonPresenter(PokedexRepository pokedexRepository) {
        mPokedexRepository = pokedexRepository;
    }

    @Override
    public Class<PokemonTarget> getTargetClazz() {
        return PokemonTarget.class;
    }

    public void loadPokemon(String pokemonId) {
        mPokedexRepository.getPokemon(pokemonId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mPokemonSubscriber);
    }

    private Subscriber<Pokemon> mPokemonSubscriber = new Subscriber<Pokemon>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            getTarget().showFailedToLoadPokemonError();
        }

        @Override
        public void onNext(Pokemon pokemon) {

            final PokemonMetaViewModel pokemonMetaViewModel = PokemonMetaViewModel.fromPokemon(pokemon);
            getTarget().showPokemonMeta(pokemonMetaViewModel);

            List<StatItemViewModel> itemViewModels = new ArrayList<>(pokemon.getStats().size());
            for (final Stat stat : pokemon.getStats()) {
                final StatItemViewModel itemViewModel = StatItemViewModel.fromStat(stat);
                itemViewModels.add(itemViewModel);
            }
            getTarget().showStats(itemViewModels);

        }
    };

}
