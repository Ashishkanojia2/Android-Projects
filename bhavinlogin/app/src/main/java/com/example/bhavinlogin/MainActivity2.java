package com.example.bhavinlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView text2;
    String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text2 = findViewById(R.id.textView3);
        Intent i = getIntent();
        a = i.getStringExtra("data");
        text2.setText("welcome to our app"+a);
    }
}