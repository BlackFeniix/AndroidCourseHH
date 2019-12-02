package com.hito.nikolay.lesson_6_utkin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter {
    private static final int WATER_TYPE = 0;
    private static final int ELECTRICITY_TYPE = 1;
    private HouseCounter[] mDataset;

    public RecyclerAdapter(HouseCounter[] _mDataset) {
        mDataset = _mDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case ELECTRICITY_TYPE:
                View viewHelp = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_house_counter_electricity, parent, false);
                return new ViewHolderHouseCounterElectricity(viewHelp);

            default:
                final View viewService = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_house_counter, parent, false);
                return new ViewHolderHouseCounter(viewService);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case WATER_TYPE:
                ViewHolderHouseCounter viewHolder0 = (ViewHolderHouseCounter)holder;
                viewHolder0.bind(mDataset[position]);
                break;
            case ELECTRICITY_TYPE:
                ViewHolderHouseCounterElectricity viewHolder2 = (ViewHolderHouseCounterElectricity)holder;
                viewHolder2.bind((HouseCounter) mDataset[position]);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataset[position] instanceof HouseElectricity)
            return ELECTRICITY_TYPE;
        else
            return WATER_TYPE;
    }
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
