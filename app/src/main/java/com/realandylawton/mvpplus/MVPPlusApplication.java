package com.realandylawton.mvpplus;

import android.app.Application;

import com.realandylawton.mvpplus.component.DaggerMVPPlusComponent;
import com.realandylawton.mvpplus.component.MVPPlusComponent;
import com.realandylawton.mvpplus.module.MVPPlusModule;

/**
 * Created by andylawton on 7/28/16.
 */
public class MVPPlusApplication extends Application {

    private MVPPlusComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerMVPPlusComponent.builder()
                .mVPPlusModule(new MVPPlusModule(this))
                .build();
    }

    public MVPPlusComponent getComponent() {
        return mComponent;
    }
}
