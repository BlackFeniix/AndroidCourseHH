package com.hito.nikolay.lesson_2_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, FirstActivity.class);
        context.startActivity(starter);
    }
}
