package com.hito.nikolay.lesson_5_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        TextView textViewCurrentTime = findViewById(R.id.textViewCurrentTime);
        textViewCurrentTime.setText(getCurrentTime());

        Button buttonFourthActivityToFourth = findViewById(R.id.buttonFourthToFourth);
        buttonFourthActivityToFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(createStartIntent(FourthActivity.this));
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);

        TextView textViewCurrentTime = findViewById(R.id.textViewCurrentTime);
        textViewCurrentTime.setText(getCurrentTime());
    }

    private String getCurrentTime() {
        String stringDate = getIntent().getStringExtra("Time");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date dateTime = new Date(Long.parseLong(stringDate));
        return dateFormat.format(dateTime);
    }

    public static Intent createStartIntent(Context context) {
        Intent intentToFourthActivity = new Intent(context, FourthActivity.class);
        intentToFourthActivity.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        String currentDate = String.valueOf(System.currentTimeMillis());

        intentToFourthActivity.putExtra("Time", currentDate);
        return intentToFourthActivity;
    }
}


