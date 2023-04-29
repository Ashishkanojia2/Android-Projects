package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1 , btn2;
    EditText txt;
    String s;
    int x=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       txt= findViewById(R.id.ed2);
       btn1 = findViewById(R.id.button1);
       btn2 = findViewById(R.id.button2);
               btn1.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       s = txt.getText().toString();
                       x = Integer.parseInt(s);
                       x=x+1;
                       txt.setText(x);
                   }
               });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s = txt.getText().toString();
                x = Integer.parseInt(s);
                x=x-1;
                txt.setText(String.valueOf(x));
            }
        });

    }

}