package com.example.incrementanddecrementno;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button1 ,button2;
    TextView textView;
    int n =0 ;
//    int a =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.Addbtn);
        button2 = findViewById(R.id.subbtn);
        textView = findViewById(R.id.showtxt);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n+=1;
                textView.setText(String.valueOf(n));

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n-=1;
                textView.setText(String.valueOf(n));
            }
        });





    }
}