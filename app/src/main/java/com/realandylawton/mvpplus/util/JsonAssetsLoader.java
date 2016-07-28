package com.realandylawton.mvpplus.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by andylawton on 7/28/16.
 */
public class JsonAssetsLoader {

    private Context mContext;
    private Gson mGson;

    public JsonAssetsLoader(Context context, Gson gson) {
        mContext = context;
        mGson = gson;
    }

    public <T> T parseFromJsonFile(String fileName, Class<T> type) throws IOException {
        String json = parseAsString(fileName);
        return mGson.fromJson(json, type);
    }

    private String parseAsString(String filename) throws IOException {

        AssetManager assetManager = mContext.getAssets();

        InputStream in = assetManager.open(filename);

        int size = in.available();
        byte[] buffer = new byte[size];

        in.read(buffer);
        in.close();

        String fileAsString = new String(buffer);

        return fileAsString;


    }
}