package com.hito.nikolay.lesson_6_utkin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment currentFragment = null;
    FragmentTransaction ft;
    FragmentManager myFragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = myFragmentManager.beginTransaction();
        currentFragment = new FirstFragment();
        ft.add(R.id.frameLayoutContainer, currentFragment);
        ft.commit();

       BottomNavigationView navigation =
                findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

   private BottomNavigationView.OnNavigationItemSelectedListener
            mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener(){
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_item_one:
                    currentFragment = new FirstFragment();
                    ft = myFragmentManager.beginTransaction();
                    ft.replace(R.id.frameLayoutContainer, currentFragment);
                    ft.commit();
                    return true;

                case R.id.navigation_item_second:
                    currentFragment = new SecondFragment();
                    ft = myFragmentManager.beginTransaction();
                    ft.replace(R.id.frameLayoutContainer, currentFragment);
                    ft.commit();
                    return true;

                case R.id.navigation_item_third:
                    currentFragment = new ThirdFragment();
                    ft = myFragmentManager.beginTransaction();
                    ft.replace(R.id.frameLayoutContainer, currentFragment);
                    ft.commit();
                    return true;
            }
            return false;
        }
    };
}
