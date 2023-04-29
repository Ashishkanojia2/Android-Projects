package com.example.login01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tv;
    String n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.edit);

        Intent i = getIntent();
        n = i.getStringExtra("login");
        tv.setText(("welcome "+ n));

    }
}