package com.hito.nikolay.lessons_1_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.TreeSet;

public class FirstActivity extends AppCompatActivity {

    TreeSet<String> studentSet = new TreeSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button saveStudent = findViewById(R.id.saveButton);
        Button showStudents = findViewById(R.id.showButton);

        saveStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputText = findViewById(R.id.editData);
                String student = inputText.getText().toString();
                if (!student.isEmpty())
                    studentSet.add(student);
                inputText.setText("");
            }
        });

        showStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textView);
                textView.setText("");
                for (String student: studentSet) {
                    textView.append(student);
                    textView.append("\n");
                }
            }
        });
    }

}
