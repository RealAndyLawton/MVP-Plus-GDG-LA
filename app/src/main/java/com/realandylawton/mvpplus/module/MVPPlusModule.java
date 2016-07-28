package com.realandylawton.mvpplus.module;

import android.content.Context;

import com.google.gson.Gson;
import com.realandylawton.mvpplus.repository.PokedexRepository;
import com.realandylawton.mvpplus.repository.PokedexStubRespository;
import com.realandylawton.mvpplus.util.GlideImageLoader;
import com.realandylawton.mvpplus.util.ImageLoader;
import com.realandylawton.mvpplus.util.JsonAssetsLoader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by andylawton on 7/28/16.
 */

@Module
public class MVPPlusModule {

    private final Context mAppContext;

    public MVPPlusModule(Context appContext) {
        mAppContext = appContext;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    JsonAssetsLoader provideJsonAssetsLoader(Gson gson) {
        return new JsonAssetsLoader(mAppContext, gson);
    }

    @Provides
    @Singleton
    PokedexRepository providePokedexRepository(JsonAssetsLoader jsonAssetsLoader) {
        return new PokedexStubRespository(jsonAssetsLoader);
    }

    @Provides
    ImageLoader provideImageLoader() {
        return new GlideImageLoader(mAppContext);
    }

}
