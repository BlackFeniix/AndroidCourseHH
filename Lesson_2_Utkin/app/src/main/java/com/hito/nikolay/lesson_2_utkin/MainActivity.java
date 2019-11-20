package com.hito.nikolay.lesson_2_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonFirstActivity = findViewById(R.id.buttonFirstActivity);
        Button buttonSecondActivity = findViewById(R.id.buttonSecondActivity);

        buttonFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstActivity.start(MainActivity.this);
            }
        });

        buttonSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecondActivity.start(MainActivity.this);
            }
        });
    }
}
