package com.realandylawton.mvpplus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.realandylawton.mvpplus.R;
import com.realandylawton.mvpplus.viewmodel.StatItemViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by andylawton on 7/28/16.
 */
public class StatItemView extends FrameLayout {

    public static StatItemView inflate(ViewGroup viewGroup) {
        return (StatItemView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.stat_item, viewGroup, false);
    }

    @BindView(R.id.stat_item_name) TextView mNameView;
    @BindView(R.id.stat_item_base) TextView mBaseView;

    public StatItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindModel(StatItemViewModel statItemViewModel) {
        mNameView.setText(statItemViewModel.getName());
        mBaseView.setText(statItemViewModel.getBaseStat());
    }

}
