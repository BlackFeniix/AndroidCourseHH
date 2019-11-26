package com.hito.nikolay.lesson_4_utkin;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderService extends RecyclerView.ViewHolder implements View.OnClickListener{

    public ImageView imageViewCard;
    public TextView textViewMain;
    public TextView textViewSecond;
    public Adapter.CustomItemClickListener itemClickListener;

    public ViewHolderService(@NonNull View itemView, Adapter.CustomItemClickListener customItemClickListener) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemClickListener = customItemClickListener;
        imageViewCard = itemView.findViewById(R.id.imageViewOfCard);
        textViewMain = itemView.findViewById(R.id.textViewOfCardMain);
        textViewSecond = itemView.findViewById(R.id.textViewOfCardSecond);
    }

    public void bind(final DetailInfo data)
    {
        imageViewCard.setImageResource(data.image);
        textViewMain.setText(data.title);
        if (data.isMarked)
            textViewSecond.setTextColor(Color.RED);
        else
            textViewSecond.setTextColor(Color.BLACK);
        textViewSecond.setText(data.subTitle);
    }

    @Override
    public void onClick(View view) {
        if (itemClickListener!=null)
            itemClickListener.onItemClick(view, getAdapterPosition());
    }
}
