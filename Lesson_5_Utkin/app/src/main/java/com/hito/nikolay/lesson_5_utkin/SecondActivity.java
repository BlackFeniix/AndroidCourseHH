package com.hito.nikolay.lesson_5_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button buttonSecondActivityToThird = findViewById(R.id.buttonSecondActivityToThird);
        buttonSecondActivityToThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ThirdActivity.createStartIntent(SecondActivity.this));
            }
        });
    }

    public static Intent createStartIntent(Context context) {
        return new Intent(context, SecondActivity.class);
    }
}
