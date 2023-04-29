package com.example.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();        // receiving intent from the main activity
        String message  = intent.getStringExtra(MainActivity.ak);   // this is used to receive the message from main activity
         // set text inside textview to message
        TextView textview = findViewById(R.id.orderText);
        textview.setText(message);
    }
}

/*      EditText ed = findViewById(R.id.editText1);
        EditText ed1 = findViewById(R.id.editText2);
        EditText ed2 = findViewById(R.id.editText3);
        Button btn = (Button) findViewById(R.id.placeOrder);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,OrderActivity.class);
                startActivity(intent);

            }*/