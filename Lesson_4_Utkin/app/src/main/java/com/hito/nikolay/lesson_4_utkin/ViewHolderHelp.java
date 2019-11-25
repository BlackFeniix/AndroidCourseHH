package com.hito.nikolay.lesson_4_utkin;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderHelp extends RecyclerView.ViewHolder {

    public ImageView imageViewCard;
    public TextView textViewMain;

    public ViewHolderHelp(@NonNull View itemView) {
        super(itemView);
        imageViewCard = itemView.findViewById(R.id.imageViewOfCard);
        textViewMain = itemView.findViewById(R.id.textViewOfCardMain);
    }

    public void bind(final BaseInfo data)
    {
        imageViewCard.setImageResource(data.image);
        textViewMain.setText(data.title);
    }
}
