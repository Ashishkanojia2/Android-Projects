package com.example.login01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn1 ;
    String name,password ,un;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ed1=findViewById(R.id.ed1);
            ed2=findViewById(R.id.ed2);
            btn1=findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start();

            }
        });

    }

    public  void start() {
        name = ed1.getText().toString();
        Intent i = new Intent(MainActivity.this,MainActivity2.class);

        i.putExtra("login",name);
        startActivity(i);
    }
}