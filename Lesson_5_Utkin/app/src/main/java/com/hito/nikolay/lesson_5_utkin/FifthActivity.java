package com.hito.nikolay.lesson_5_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {
    Data dataFromEditText;
    static final String INTENT_KEY = "Text";
    static final String PARCELABLE_KEY = "Data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        final EditText editTextFifthActivity = findViewById(R.id.editTextFifthActivity);

        Button buttonFifthActivityDeliverResult = findViewById(R.id.buttonFifthActivityDeliverResult);
        buttonFifthActivityDeliverResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextFifthActivity.getText().toString();
                Intent intent = new Intent(FifthActivity.this, ThirdActivity.class);
                intent.putExtra(INTENT_KEY, text);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button buttonFifthActivitySave = findViewById(R.id.buttonFifthActivitySave);
        buttonFifthActivitySave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataFromEditText= new Data();
                dataFromEditText.value = editTextFifthActivity.getText().toString();

                TextView textViewFifthActivity = findViewById(R.id.textViewFifthActivity);
                textViewFifthActivity.setText(dataFromEditText.value);
            }
        });
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARCELABLE_KEY, dataFromEditText);
    }

    @Override
    public void onRestoreInstanceState(Bundle state) {
        super.onRestoreInstanceState(state);
        dataFromEditText =state.getParcelable(PARCELABLE_KEY);
        if (dataFromEditText!=null)
        {
            TextView textViewFifthActivity = findViewById(R.id.textViewFifthActivity);
            textViewFifthActivity.setText(dataFromEditText.value);
        }
    }
}
