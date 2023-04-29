package com.example.bhavinlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText id;
    EditText pass;
    String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        id = findViewById(R.id.ID);
        pass = findViewById(R.id.pass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID = id.getText().toString();
                Intent i = new Intent(MainActivity.this,MainActivity2.class);
                i.putExtra("data",ID);
                startActivity(i);

            }
        });

    }
}