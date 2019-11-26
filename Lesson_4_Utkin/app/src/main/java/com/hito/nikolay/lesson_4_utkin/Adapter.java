package com.hito.nikolay.lesson_4_utkin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private static final int SERVICE_TYPE = 0;
    private static final int HELP_TYPE = 1;

    private BaseInfo[] mDataset;
    private CustomItemClickListener adapterClickListener;

    public Adapter(BaseInfo[] myDataset){
        mDataset=myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        switch (viewType) {
            case HELP_TYPE:
                View viewHelp = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_recycler_help, parent, false);
                return new ViewHolderHelp(viewHelp, adapterClickListener);

            default:
                final View viewService = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_recycler_service, parent, false);
                return new ViewHolderService(viewService,adapterClickListener);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case SERVICE_TYPE:
                ViewHolderService viewHolder0 = (ViewHolderService)holder;
                viewHolder0.bind((DetailInfo) mDataset[position]);
                break;

            case HELP_TYPE:
                ViewHolderHelp viewHolder2 = (ViewHolderHelp)holder;
                viewHolder2.bind(mDataset[position]);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position %2 ==0 && mDataset[position] instanceof DetailInfo &&
                (position+1< mDataset.length && !(mDataset[position+1] instanceof DetailInfo) ||
                        position+1==mDataset.length  ))
        {
            return HELP_TYPE;
        }
        if (mDataset[position] instanceof DetailInfo)
            return SERVICE_TYPE;
        else
            return HELP_TYPE;
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

