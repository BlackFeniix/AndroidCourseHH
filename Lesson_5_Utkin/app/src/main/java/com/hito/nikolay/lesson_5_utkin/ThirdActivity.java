package com.hito.nikolay.lesson_5_utkin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class ThirdActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_FOR_FIFTH = 404;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button buttonThirdActivityToFirst = findViewById(R.id.buttonThirdActivityToFirst);
        buttonThirdActivityToFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.startFirstActivity(ThirdActivity.this);
            }
        });

        Button buttonThirdActivityToFifth = findViewById(R.id.buttonThirdActivityToFifth);
        buttonThirdActivityToFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThirdActivity.this, FifthActivity.class);
                startActivityForResult(intent, REQUEST_CODE_FOR_FIFTH);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_FOR_FIFTH) {
            if(resultCode == RESULT_OK){
                String result= data.getStringExtra("Text");
                ViewGroup rootView = (ViewGroup) ((ViewGroup) this
                        .findViewById(android.R.id.content)).getChildAt(0);
                Snackbar.make(rootView, result, Snackbar.LENGTH_LONG).show();
            }
            if (resultCode == RESULT_CANCELED) {
            }
        }
    }

    public static void startThirdActivity(Context context) {
        Intent intentToThirdActivity = new Intent(context, ThirdActivity.class);
        context.startActivity(intentToThirdActivity);
    }
}
