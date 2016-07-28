package com.realandylawton.mvpplus.activity;

import android.content.Context;
import android.test.ActivityUnitTestCase;
import android.widget.ImageView;
import android.widget.TextView;

import com.realandylawton.mvpplus.util.ImageLoader;
import com.realandylawton.mvpplus.view.StatListView;
import com.realandylawton.mvpplus.viewmodel.PokemonMetaViewModel;
import com.realandylawton.mvpplus.viewmodel.StatItemViewModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by andylawton on 7/28/16.
 */
public class PokemonActivityTest {

    private static final String NAME = "Charizard";
    private static final String URL_FRONT = "urlfront";
    private static final String URL_BACK = "urlback";

    PokemonActivity mActivity = new PokemonActivity();
    @Mock ImageLoader mImageLoaderMock;
    @Mock TextView mNameViewMock;
    @Mock StatListView mStatListViewMock;
    @Mock ImageView mFrontImageView;
    @Mock ImageView mBackImageView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mActivity.mNameView = mNameViewMock;
        mActivity.mImageLoader = mImageLoaderMock;
        mActivity.mFrontImage = mFrontImageView;
        mActivity.mBackImage = mBackImageView;
        mActivity.mStatListView = mStatListViewMock;
    }

    @Test
    public void showPokemonMeta_bindNameView() throws Exception {

        final PokemonMetaViewModel viewModelMock = mock(PokemonMetaViewModel.class);
        when(viewModelMock.getName()).thenReturn(NAME);

        mActivity.showPokemonMeta(viewModelMock);

        verify(mNameViewMock).setText(NAME);

    }

    @Test
    public void showPokemonMeta_loadImages() throws Exception {

        final PokemonMetaViewModel viewModelMock = mock(PokemonMetaViewModel.class);
        when(viewModelMock.getFrontSpriteUrl()).thenReturn(URL_FRONT);
        when(viewModelMock.getBackSpriteUrl()).thenReturn(URL_BACK);

        mActivity.showPokemonMeta(viewModelMock);

        verify(mImageLoaderMock).loadUrlInto(URL_FRONT, mFrontImageView);
        verify(mImageLoaderMock).loadUrlInto(URL_BACK, mBackImageView);

    }

    @Test
    public void showStats_listViewShowStats() throws Exception {

        final List<StatItemViewModel> viewModelsMock = Collections.singletonList(mock(StatItemViewModel.class));

        mActivity.showStats(viewModelsMock);

        verify(mStatListViewMock).showStats(viewModelsMock);

    }
}
