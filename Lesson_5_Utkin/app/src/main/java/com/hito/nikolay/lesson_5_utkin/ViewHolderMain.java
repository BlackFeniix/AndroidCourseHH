package com.hito.nikolay.lesson_5_utkin;

import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderMain extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imageViewCard;
    private TextView textViewFirst;
    private TextView textViewSecond;
    private TextView textViewThird;
    public Adapter.CustomItemClickListener itemClickListener;

    public ViewHolderMain(@NonNull View itemView,Adapter.CustomItemClickListener customItemClickListener) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemClickListener = customItemClickListener;
        imageViewCard = itemView.findViewById(R.id.imageViewOfCard);
        textViewFirst = itemView.findViewById(R.id.textViewOfCardFirst);
        textViewSecond = itemView.findViewById(R.id.textViewOfCardSecond);
        textViewThird = itemView.findViewById(R.id.textViewOfCardThird);

    }

    public void bind(final ItemData data)
    {
        Glide
                .with(itemView)
                .load(data.imageURL)
                .into(imageViewCard);
        textViewFirst.setText(data.name);
        textViewSecond.setText(data.promo);
        textViewThird.setText(data.address);
    }

    @Override
    public void onClick(View view) {
        if (itemClickListener!=null)
            itemClickListener.onItemClick(view, getAdapterPosition());
    }
}
