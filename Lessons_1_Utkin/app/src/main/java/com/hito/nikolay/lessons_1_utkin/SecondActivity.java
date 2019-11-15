package com.hito.nikolay.lessons_1_utkin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class SecondActivity extends AppCompatActivity {

    HashMap<Integer,Student> studentArrayList = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button showStudents = findViewById(R.id.buttonShowAllStudents);

        final TextView textView = findViewById(R.id.textView);
        final EditText editData = findViewById(R.id.editData);

        editData.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
            {
                // Perform action on key press
                if (editData.getText().length() != 0)
                {
                    Student newStudent = new Student(editData.getText().toString());
                    studentArrayList.put(newStudent.id, newStudent);
                    editData.setText("");
                }

                return true;
            }

            return false; }
        });

        showStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                for(Map.Entry<Integer, Student> student : studentArrayList.entrySet()) {
                    Student value = student.getValue();
                    textView.append( value + "\n");
                }
            }
        });
    }

}
