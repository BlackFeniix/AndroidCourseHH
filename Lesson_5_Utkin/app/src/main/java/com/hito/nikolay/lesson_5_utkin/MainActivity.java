package com.hito.nikolay.lesson_5_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFirstActivityToFourth = findViewById(R.id.buttonFirstActivityToFourth);
        buttonFirstActivityToFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               FourthActivity.startFourthActivity(MainActivity.this);
            }
        });

        Button buttonFirstActivityToSecond = findViewById(R.id.buttonFirstActivityToSecond);
        buttonFirstActivityToSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.startSecondActivity(MainActivity.this);
            }
        });
    }

    public static void startFirstActivity(Context context) {
        Intent intentToFirstActivity = new Intent(context, MainActivity.class);
        context.startActivity(intentToFirstActivity);
    }
}
