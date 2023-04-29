package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String ak = " com. ashishKanojia.multiscreen.ORDER";  // this is a key value pair to send a next activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ed = findViewById(R.id.editText1);
        EditText ed1 = findViewById(R.id.editText2);
        EditText ed2 = findViewById(R.id.editText3);
        Button btn = (Button) findViewById(R.id.placeOrder);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);

            }
        });

    }
}