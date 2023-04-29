package com.example.roomlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        btn1 = findViewById(R.id.btn1);

        DataBaseHelper dataBaseHelper = DataBaseHelper.getdb(this);
        //DataBaseHelper.expense.dao


    }
}