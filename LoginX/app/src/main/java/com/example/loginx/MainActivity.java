package com.example.loginx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = findViewById(R.id.username);
        TextView password = findViewById(R.id.password);
        MaterialButton Button  = (MaterialButton) findViewById(R.id.singinbtn);
        TextView Try = findViewById(R.id.Try);


        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("admin")&& password.getText().toString().equals("admin")){
                    // correct
                 //   Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "SIGN-IN SUCCESSFUL", Toast.LENGTH_LONG).show();
                    Intent intt =new Intent(MainActivity.this,MainActivity2.class);
                            startActivity(intt);

                }
                else {
                    // incorrect
                    Toast.makeText(MainActivity.this, "SIGN-IN FAILED", Toast.LENGTH_SHORT).show();

                    username.setVisibility(View.VISIBLE);
                    password.setBackgroundColor(Color.RED);
                    counter--;
                    Try.setText("You Have Only "+ Integer.toString(counter) + " Chance!! Please Try Again");

                    if(counter==0){
                        Button.setEnabled(false);
                        Button.setVisibility(View.INVISIBLE);
                        Try.setVisibility(View.INVISIBLE);
                        Try.setVisibility(View.VISIBLE);
                        Try.setText("Opps.. You Try Your Best");

                    }


                }
            }
        });




   /*     Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intt =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intt);
            }
        });*/
    }
}

//  Button.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            Intent intt =new Intent(MainActivity.this,MainActivity2.class);
//                            startActivity(intt);
//                        }
//                    });

//else part
/*tx1.setVisibility(View.VISIBLE);
        tx1.setBackgroundColor(Color.RED);
        counter--;
        tx1.setText(Integer.toString(counter));

        if (counter == 0) {
        b1.setEnabled(false);
        }*/


   /*username.setVisibility(View.VISIBLE);
           password.setBackgroundColor(Color.RED);
           counter--;
           username.setText(Integer.toString(counter));

           if (counter == 0) {
           Button.setEnabled(false);

           }*/





