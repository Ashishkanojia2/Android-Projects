package com.example.bracodescanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {
//initialize variable
    Button button;
    TextView txtview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       //assign variable
        button= findViewById(R.id.ScnBtn1);
        txtview = findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Intent i= new Intent(MainActivity.this,ScannerView.class);
                startActivity(i);*/
                //***
                //***

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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //initialize intent result
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode,resultCode,data
        );
        //check condition
        if(intentResult.getContents() != null){
            //when result content  is not null
            //initialize alert dialog
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
