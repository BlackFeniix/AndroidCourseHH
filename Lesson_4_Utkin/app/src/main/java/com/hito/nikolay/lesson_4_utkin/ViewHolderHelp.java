package com.hito.nikolay.lesson_4_utkin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderHelp extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageViewCard;
    public TextView textViewMain;
    public Adapter.CustomItemClickListener itemClickListener;

    public ViewHolderHelp(@NonNull View itemView, Adapter.CustomItemClickListener customItemClickListener) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemClickListener = customItemClickListener;
        imageViewCard = itemView.findViewById(R.id.imageViewOfCard);
        textViewMain = itemView.findViewById(R.id.textViewOfCardMain);
    }

    public void bind(final BaseInfo data)
    {
        imageViewCard.setImageResource(data.image);
        textViewMain.setText(data.title);
    }

    @Override
    public void onClick(View view) {
        if (itemClickListener!=null)
            itemClickListener.onItemClick(view, getAdapterPosition());
    }
}
