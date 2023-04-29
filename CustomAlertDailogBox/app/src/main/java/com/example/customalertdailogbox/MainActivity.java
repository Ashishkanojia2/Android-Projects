package com.example.customalertdailogbox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// if we create an custom dialog box then we use dialog class
        
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_alert_box);
        dialog.show();
    }
}