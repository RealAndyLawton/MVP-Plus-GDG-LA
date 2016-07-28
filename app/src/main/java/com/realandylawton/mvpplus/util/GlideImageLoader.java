package com.realandylawton.mvpplus.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by andylawton on 7/28/16.
 */
public class GlideImageLoader implements ImageLoader {

    private Context mContext;

    public GlideImageLoader(Context context) {
        mContext = context;
    }

    @Override
    public void loadUrlInto(String url, ImageView imageView) {
        Glide.with(mContext)
                .load(url)
                .into(imageView);
    }
}
