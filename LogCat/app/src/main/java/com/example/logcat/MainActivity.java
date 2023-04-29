package com.example.logcat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Tag","Tag_Message");

        String Tag="FirstTag";
        Log.d(Tag,"This is My First logCat Message");
        Log.e("errorTAG","this is My First Error Tag");
    }
}