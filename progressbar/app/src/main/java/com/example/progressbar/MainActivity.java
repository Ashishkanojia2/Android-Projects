package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button plus;
    Button minus;
    TextView showPercentage;
    ProgressBar prog;
    int showProg=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        showPercentage = findViewById(R.id.textView);
        prog = findViewById(R.id.progressBar2);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showProg < 100){
                    showProg+=10;
                    prog.setProgress(showProg);
                    showPercentage.setText(String.valueOf(showProg));
                }

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showProg > 0){
                showProg-=10;
                prog.setProgress(showProg);
                showPercentage.setText(String.valueOf(showProg));
                }

            }
        });

    }
}