package com.hito.nikolay.lesson_4_utkin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private BaseInfo[] mDataset;

    public Adapter(BaseInfo[] myDataset){
        mDataset=myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_recycler_service, parent, false);
                return new ViewHolderService(view);

            case 1:
                View view2 = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_help, parent, false);
                return new ViewHolderHelp(view2);

            default:
                View view3 = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_recycler_service, parent, false);
                return new ViewHolderService(view3);
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        switch (holder.getItemViewType()) {
            case 0:
                ViewHolderService viewHolder0 = (ViewHolderService)holder;
                viewHolder0.bind((DetailInfo) mDataset[position]);
                break;

            case 1:
                ViewHolderHelp viewHolder2 = (ViewHolderHelp)holder;
                viewHolder2.bind(mDataset[position]);
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar mySnackBar;
                mySnackBar = Snackbar.make(
                        holder.itemView, mDataset[position].title, Snackbar.LENGTH_LONG);
                mySnackBar.show();
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        if (position+1< mDataset.length && !(mDataset[position+1] instanceof DetailInfo) &&
                mDataset[position] instanceof DetailInfo)
        {
            return 1;
        }
        if (mDataset[position] instanceof DetailInfo)
            return 0;
        else
            return 1;
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
