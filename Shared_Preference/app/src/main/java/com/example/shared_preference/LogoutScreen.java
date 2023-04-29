package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogoutScreen extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_screen);
        btn.findViewById(R.id.logout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag",false);
                editor.apply();
            }
        });
    }
}