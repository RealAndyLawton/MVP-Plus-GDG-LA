package com.realandylawton.mvpplus.presenter;

import com.realandylawton.mvpplus.model.Pokemon;
import com.realandylawton.mvpplus.presenter.PokemonPresenter;
import com.realandylawton.mvpplus.repository.PokedexRepository;
import com.realandylawton.mvpplus.target.PokemonTarget;
import com.realandylawton.mvpplus.viewmodel.PokemonMetaViewModel;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.Callable;

import rx.Observable;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by andylawton on 7/28/16.
 */
public class PokemonPresenterTest {

    @Mock PokedexRepository mRepositoryMock;
    @Mock PokemonTarget mPokemonTargetMock;
    @InjectMocks PokemonPresenter mPresenter;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mPresenter.takeTarget(mPokemonTargetMock);
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @After
    public void tearDown() throws Exception {
        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void loadPokemon_onError_showErrorMessage() throws Exception {

        when(mRepositoryMock.getPokemon(anyString()))
                .thenReturn(Observable.fromCallable(new Callable<Pokemon>() {
                            @Override
                            public Pokemon call() throws Exception {
                                throw new Exception();
                            }
                        }));

        mPresenter.loadPokemon("1");

        verify(mPokemonTargetMock).showFailedToLoadPokemonError();

    }

    @Test
    public void loadPokemon_onNext_showMetaAndStats() throws Exception {

        final Pokemon pokemonMock = mock(Pokemon.class);
        when(mRepositoryMock.getPokemon(anyString()))
                .thenReturn(Observable.just(pokemonMock));

        mPresenter.loadPokemon("1");

        verify(mPokemonTargetMock).showPokemonMeta(any(PokemonMetaViewModel.class));
        verify(mPokemonTargetMock).showStats(anyList());

    }

}
