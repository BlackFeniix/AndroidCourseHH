package com.hito.nikolay.lesson_4_utkin;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderService extends RecyclerView.ViewHolder {

    public ImageView imageViewCard;
    public TextView textViewMain;
    public TextView textViewSecond;

    public ViewHolderService(@NonNull View itemView) {
        super(itemView);
        imageViewCard = itemView.findViewById(R.id.imageViewOfCard);
        textViewMain = itemView.findViewById(R.id.textViewOfCardMain);
        textViewSecond = itemView.findViewById(R.id.textViewOfCardSecond);
    }

    public void bind( DetailInfo data)
    {
        imageViewCard.setImageResource(data.image);
        textViewMain.setText(data.title);
        textViewSecond.setTextColor(Color.BLACK);
        if (data.isMarked)
        {
            textViewSecond.setTextColor(Color.RED);
        }
        textViewSecond.setText(data.subTitle);
    }
}
