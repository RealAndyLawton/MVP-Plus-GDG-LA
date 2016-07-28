package com.realandylawton.mvpplus.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.realandylawton.mvpplus.viewmodel.StatItemViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by andylawton on 7/28/16.
 */
public class StatListView extends ListView {

    private List<StatItemViewModel> mStats = Collections.emptyList();

    public StatListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAdapter(mAdapter);
    }

    private final BaseAdapter mAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return mStats.size();
        }

        @Override
        public StatItemViewModel getItem(int i) {
            return mStats.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            StatItemView itemView = (view == null) ? StatItemView.inflate(viewGroup) : (StatItemView)view;
            final StatItemViewModel model = getItem(i);
            itemView.bindModel(model);
            return itemView;
        }

    };

    public void showStats(List<StatItemViewModel> stats) {
        mStats = stats;
        mAdapter.notifyDataSetChanged();
    }
}
