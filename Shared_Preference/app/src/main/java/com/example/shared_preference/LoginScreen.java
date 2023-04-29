package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginScreen extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        btn.findViewById(R.id.login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code of varification
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                //To set the value in shared preference .....  we can easily get the value of shared pref. but to set the value we used editor.
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("flag",true);
                editor.apply();
                Intent in = new Intent(LoginScreen.this,LogoutScreen.class);
                startActivity(in);
            }
        });
    }

}