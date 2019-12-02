package com.hito.nikolay.lesson_6_utkin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderHouseCounterElectricity extends RecyclerView.ViewHolder {

    public ImageView imageViewIconCard;
    public TextView textViewName;
    public TextView textViewBarCode;
    public TextView textViewFilingDate;

    public ViewHolderHouseCounterElectricity(@NonNull View itemView) {
        super(itemView);
        imageViewIconCard = itemView.findViewById(R.id.imageViewIconCard);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewBarCode = itemView.findViewById(R.id.textViewBarCode);
        textViewFilingDate = itemView.findViewById(R.id.textViewFilingDate);
    }

    public void bind(final HouseCounter data) {
        imageViewIconCard.setImageResource(data.image);
        textViewName.setText(data.name);
        textViewBarCode.setText(data.barCode);
        textViewFilingDate.setText(data.latestDate);
        if (data.isDateExpired)
        {
            textViewFilingDate.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.ic_alert, 0, 0, 0);
        }
    }
}
