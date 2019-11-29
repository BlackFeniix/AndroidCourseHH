package com.hito.nikolay.lesson_5_utkin;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.android.material.appbar.CollapsingToolbarLayout;


public class SixActivity extends AppCompatActivity {
    static final String TOOLBAR_FONT_IMAGE_URL = "https://prawdom.ru/foto/gr-135172.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);


        float scaleRatio = getResources().getDisplayMetrics().density;
        float dimenPix = getResources().getDimension(R.dimen.item_offset);
        int dimenOrginal =(int)(dimenPix/scaleRatio);

        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        final Adapter mAdapter = new Adapter(CreateDataForRecyclerView());
        mAdapter.setCustomItemClickListener(new Adapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(SixActivity.this,"Toast is worked",Toast.LENGTH_LONG).show();
            }
        });
        recyclerView.setAdapter(mAdapter);


        final CollapsingToolbarLayout collapsingToolbarServices = findViewById(R.id.collapsingToolbarServices);
        Glide.with(SixActivity.this)
                .load(TOOLBAR_FONT_IMAGE_URL)
                .into(new CustomTarget<Drawable>() {
                    private Drawable resource;
                    @Nullable
                    private Transition<? super Drawable> transition;

                    @Override
                    public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                        collapsingToolbarServices.setBackground(resource);
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {

                    }
                });

        RelativeLayout  layoutAllService = findViewById(R.id.layoutAllService);
        layoutAllService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SixActivity.this,"Services",Toast.LENGTH_LONG).show();
            }
        });

        TextView textViewRecommendService = findViewById(R.id.textViewRecommendService);
        textViewRecommendService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SixActivity.this,"Recommend service",Toast.LENGTH_LONG).show();
            }
        });
    }

    public static Intent createStartIntent(Context context) {
        return new Intent(context, SixActivity.class);
    }

    public ItemData[] CreateDataForRecyclerView() {
        return new ItemData[]{
                new ItemData("Царь пышка", "Скидка 10% на выпечку \n" +
                        "по коду", "Лермонтовский пр, 52, МО №1",
                        "https://images.foody.vn/res/g68/672495/prof/s640x400/foody-mobile-bakery-erp-software--321-636350158337472925.jpg"),
                new ItemData("Химчистка «МАЙ?»", "Скидка 5% на чистку пальто",
                        "Лермонтовский пр, 48",
                        "https://www.clipartmax.com/png/small/382-3825037_washing-machine-laundromat-royalty-free-vector-clip-washing-machine-laundromat-royalty-free.png"),
                new ItemData("Шаверма У Ашота ", "При покупке шавермы,\n фалафель бесплатно",
                        "Лермонтовский пр, 52, МО №1",
                        "https://img01.flagma.by/photo/shaurma-2196981_medium.jpg"),

                new ItemData("Царь пышка", "Скидка 10% на выпечку \n" +
                        "по коду", "Лермонтовский пр, 52, МО №1",
                        "https://images.foody.vn/res/g68/672495/prof/s640x400/foody-mobile-bakery-erp-software--321-636350158337472925.jpg"),
                new ItemData("Химчистка «МАЙ?»", "Скидка 5% на чистку пальто",
                        "Лермонтовский пр, 48",
                        "https://www.clipartmax.com/png/small/382-3825037_washing-machine-laundromat-royalty-free-vector-clip-washing-machine-laundromat-royalty-free.png"),
                new ItemData("Шаверма У Ашота ", "При покупке шавермы,\n фалафель бесплатно",
                        "Лермонтовский пр, 52, МО №1",
                        "https://img01.flagma.by/photo/shaurma-2196981_medium.jpg")
        };
    }
}
