package com.andy.baselibrary.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andy.baselibrary.holder.DataBindRecyclerHolder;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Andy on 2017/3/8.
 */

public abstract class DataBindRecyclerAdapter<T> extends BaseRecyclerdapter<T> {
    private int idResLayout;

    public DataBindRecyclerAdapter(Context mContext, @NotNull int idResLayout) {
        super(mContext);
        this.idResLayout = idResLayout;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemRootView = mLayoutInflater.inflate(this.idResLayout, parent, false);
        return getHolder(itemRootView);
    }

    public abstract DataBindRecyclerHolder<T> getHolder(View itemView);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DataBindRecyclerHolder<T> bindHolder = (DataBindRecyclerHolder) holder;
        bindHolder.bind(getItem(position));
    }
}
