package com.example.ownbottomnav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class MainActivity extends AppCompatActivity {
        BottomNavigationItemView bottomNavigationItemView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationItemView =findViewById(R.id.BottomNav);


    }
}