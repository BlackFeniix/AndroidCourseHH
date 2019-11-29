package com.hito.nikolay.lesson_5_utkin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ItemData[] mDataset;

    private CustomItemClickListener adapterClickListener;
    public Adapter(ItemData[] myDataset) {
        mDataset = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewMain = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler, parent, false);
        return new ViewHolderMain(viewMain, adapterClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderMain viewHolderMain = (ViewHolderMain) holder;
        viewHolderMain.bind(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public interface CustomItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setCustomItemClickListener(CustomItemClickListener customItemClickListener) {
        this.adapterClickListener = customItemClickListener;
    }
}
