package com.hito.nikolay.lesson_3_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonConstraintLayout = findViewById(R.id.buttonConstraintLayout);
        Button buttonUsualLayout = findViewById(R.id.buttonUsualLayout);



        buttonConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConstraintLayoutActivity.start(MainActivity.this);
            }
        });

        buttonUsualLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsualLayoutActivity.start(MainActivity.this);
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(starter);
    }
}
