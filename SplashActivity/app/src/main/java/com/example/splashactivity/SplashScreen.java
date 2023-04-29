package com.example.splashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//    //    Intent iHome = new Intent (SplashScreen.this,MainActivity.class);    //anywhere
        new Handler().postDelayed(new Runnable() {     // handler is help to handler something 
            @Override
            public void run() {
                Intent iHome = new Intent (SplashScreen.this,MainActivity.class);    // this is Intent define // this is not main part we can define intent anywhere
                startActivity(iHome);   // Main part of intent is this Start Activity
            }
        },5000);
       // Intent iHome = new Intent (SplashScreen.this,MainActivity.class);  //anywhere

    }
}
// Change Intent Filter form Manifest file  default it is present in MainActivity