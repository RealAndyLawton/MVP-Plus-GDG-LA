package com.realandylawton.mvpplus.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.realandylawton.mvpplus.MVPPlusApplication;
import com.realandylawton.mvpplus.R;
import com.realandylawton.mvpplus.presenter.PokemonPresenter;
import com.realandylawton.mvpplus.target.PokemonTarget;
import com.realandylawton.mvpplus.util.ImageLoader;
import com.realandylawton.mvpplus.view.StatListView;
import com.realandylawton.mvpplus.viewmodel.PokemonMetaViewModel;
import com.realandylawton.mvpplus.viewmodel.StatItemViewModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PokemonActivity extends AppCompatActivity implements PokemonTarget{

    private static final String CHARIZARD_ID = "6";

    @Inject PokemonPresenter mPresenter;
    @Inject ImageLoader mImageLoader;
    @BindView(R.id.pokemon_name) TextView mNameView;
    @BindView(R.id.pokemon_front) ImageView mFrontImage;
    @BindView(R.id.pokemon_back) ImageView mBackImage;
    @BindView(R.id.pokemon_stat_list) StatListView mStatListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((MVPPlusApplication) getApplicationContext()).getComponent().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.takeTarget(this);
        mPresenter.loadPokemon(CHARIZARD_ID);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.dropTarget();
    }

    @Override
    public void showPokemonMeta(PokemonMetaViewModel viewModel) {
        mNameView.setText(viewModel.getName());
        mImageLoader.loadUrlInto(viewModel.getFrontSpriteUrl(), mFrontImage);
        mImageLoader.loadUrlInto(viewModel.getBackSpriteUrl(), mBackImage);
    }

    @Override
    public void showStats(List<StatItemViewModel> stats) {
        mStatListView.showStats(stats);
    }

    @Override
    public void showFailedToLoadPokemonError() {
        Toast.makeText(this, "Failed to load Pokemon", Toast.LENGTH_LONG).show();
    }
}

