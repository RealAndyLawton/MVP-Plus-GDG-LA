package com.realandylawton.mvpplus.viewmodel;

import com.realandylawton.mvpplus.model.Stat;

/**
 * Created by andylawton on 7/28/16.
 */
public class StatItemViewModel {

    public static StatItemViewModel fromStat(Stat stat) {
        final StatItemViewModel statItemViewModel = new StatItemViewModel();
        statItemViewModel.mStat = stat;
        return statItemViewModel;
    }

    private Stat mStat;

    public String getName() {
        return mStat.getMeta().getName();
    }

    public String getBaseStat() {
        return String.valueOf(mStat.getBaseStat());
    }

}
