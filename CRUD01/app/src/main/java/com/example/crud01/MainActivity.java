package com.example.crud01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper dbhelper= new dbhelper(this);
        dbhelper.addContact("ashish","8003989125");
        dbhelper.addContact("ashi","8003989125");
        dbhelper.addContact("rohit","8003989125");
        dbhelper.addContact("shivam","8003989125");
        dbhelper.addContact("ankit","8003989125");
    }
}