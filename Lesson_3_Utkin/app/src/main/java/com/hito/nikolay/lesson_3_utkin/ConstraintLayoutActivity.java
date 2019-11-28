package com.hito.nikolay.lesson_3_utkin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class ConstraintLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.profile_menu);

        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(ConstraintLayoutActivity.this, "Back clicked!",     Toast.LENGTH_SHORT).show();
                MainActivity.start(ConstraintLayoutActivity.this);
            }
        });

        User user = new User("Анастасия", "Антонина", "anykee.box@gmail.ru",
                "HIE023UOI88", "Санкт-Петербург", 7898769);

        TextView textViewCardText = findViewById(R.id.textViewCardText);
        textViewCardText.setText("Карта #"+ user.cardNumber + "\nСпециалист");

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(user.name);

        TextView textViewSurname = findViewById(R.id.textViewSurname);
        textViewSurname.setText(user.surname);

        TextView textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(user.email);

        TextView textViewLogin = findViewById(R.id.textViewLogin);
        textViewLogin.setText(user.login);

        TextView textViewRegion = findViewById(R.id.textViewRegion);
        textViewRegion.setText(user.region);

        ImageButton buttonEditRegion = findViewById(R.id.buttonEditRegion);
        buttonEditRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConstraintLayoutActivity.this, "Whooh! Region Change", Toast.LENGTH_SHORT).show();
            }
        });

        Button buttonExitFromAccount = findViewById(R.id.buttonExitFromAccount);
        buttonExitFromAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ConstraintLayoutActivity.this, "Whooh! Log Out", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ConstraintLayoutActivity.class);
        context.startActivity(starter);
    }
}
