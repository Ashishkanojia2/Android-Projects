package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username,password,repassword;
    Button signin,al_signin;
    DBHelper DB;        // this is an object of DBHelper class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.Username);
        password = findViewById(R.id.Password);
        repassword = findViewById(R.id.Con_Password);
        signin =findViewById(R.id.register);
        al_signin =findViewById(R.id.AL_register);
// class_Name Object_Name = new keyword class_Name;
//    DBHelper    DB     =  new         DBHelper;
        DB = new DBHelper(this);             // this is an Object of DBHelper class

        //set On click listener on Button

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repassword.getText().toString();

            if(TextUtils.isEmpty(user) || TextUtils.isEmpty(pass) || TextUtils.isEmpty(repass) )
                Toast.makeText(MainActivity.this, "All Fields Required", Toast.LENGTH_SHORT).show();
            else{
                if(pass.equals(repass)){
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(user,pass);
                        if(insert==true){
                            Toast.makeText(MainActivity.this, "Registered successful", Toast.LENGTH_SHORT).show();
                            Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Registered Failed", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "User Already exists", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Password Is Not Match", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });
        al_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            }
        });
    }
}