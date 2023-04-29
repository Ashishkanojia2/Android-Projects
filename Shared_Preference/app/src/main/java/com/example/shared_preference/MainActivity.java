package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
/*    **************

    Something is wrong in this code
    
    ****************
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // In share preference before set the value we get the value of the shared preference means by default the valuer of
                // shared preference is false
                SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
               Boolean check =  pref.getBoolean("flag",false); //by default false value set

                Intent inti;
                if(check){// if check  is true
                    inti=new Intent(MainActivity.this,LogoutScreen.class);
                }else{ // this else part is run when user is used first time or logout
                    inti=new Intent(MainActivity.this,LoginScreen.class);
                }
                startActivity(inti);

            }
        },4000);
    }
}