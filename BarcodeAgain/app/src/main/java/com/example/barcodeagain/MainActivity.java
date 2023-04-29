package com.example.barcodeagain;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //initialize variable
    Button button;
    EditText textView;
    ListView listView;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assign variable
        button = findViewById(R.id.ScnBtn1);
        textView = findViewById(R.id.textView);
        button2 = findViewById(R.id.button2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intentIntegrator = new IntentIntegrator(MainActivity.this);
                //set prompt text
                intentIntegrator.setPrompt("for flash  use volume up key");
                //set beep
                intentIntegrator.setBeepEnabled(true);
                //locked orientation
                intentIntegrator.setOrientationLocked(true);
                //set capture activity
                intentIntegrator.setCaptureActivity(Capture.class);
                intentIntegrator.initiateScan();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getText().toString();
                if (text == null || text.length() == 0) {
                    Toast.makeText(MainActivity.this, "Enter valid things", Toast.LENGTH_SHORT).show();

                } else {
                    additem(text);
                    textView.setText("");
                }
            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //initialize intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data
        );
        ArrayList<String> contacts = new ArrayList<>();
        contacts.add(intentResult.getContents());
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);

        textView
        //check condition
        if (intentResult.getContents() != null) {

            }

            AlertDialog.Builder builder = new AlertDialog.Builder(
                    MainActivity.this
            );
            // set title
            builder.setTitle("Result");
            //setMessage

            builder.setMessage(intentResult.getContents());
            //set positive button
            builder.setPositiveButton("ok ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //dismiss
//                    DialogInterface.dismiss();
                }
            });
            // show alter dailog
            builder.show();
        }else{
            //when result content not null
            Toast.makeText(this, "opps try again", Toast.LENGTH_SHORT).show();
        }
    }
}

