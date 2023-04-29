package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button plus;
    Button minus;
    Button multiply;
    Button division;
    TextView value1;
    TextView value2;
    TextView result;
    int v1 ,v2 ,v3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        result = findViewById(R.id.textView2);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Integer.parseInt(value1.getText().toString());
                v2 = Integer.parseInt(value2.getText().toString());
                v3 = v1 + v2;
               // result.setText(String.valueOf(v3));
                result.setText("the value "+v3);

            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Integer.parseInt(value1.getText().toString());
                v2 = Integer.parseInt(value2.getText().toString());
                v3 = v1- v2;
                result.setText(String.valueOf(v3));
//                result = String.valueOf(v3);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Integer.parseInt(value1.getText().toString());
                v2 = Integer.parseInt(value2.getText().toString());
                v3 = v1* v2;
                result.setText(String.valueOf(v3));
//                result = String.valueOf(v3);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1 = Integer.parseInt(value1.getText().toString());
                v2 = Integer.parseInt(value2.getText().toString());
                v3 = v1/ v2;
                result.setText(String.valueOf(v3));
//                result = String.valueOf(v3);
            }
        });
    }
}