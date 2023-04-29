package com.example.impliciteintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnShare,btnEmail,btnDail, btnMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDail = findViewById(R.id.btndial);
        btnShare = findViewById(R.id.btnShare);
        btnMsg = findViewById(R.id.btnMsg);
        btnEmail =  findViewById(R.id.btnEmail);


    }
}