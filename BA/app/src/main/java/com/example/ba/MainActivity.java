package com.example.ba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
      Button ScanButton;
      Button Addbutton;
      ListView listView;
      EditText edit;
    ArrayList<String> ProductPrice;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ScanButton = findViewById(R.id.ScnBtn);
        Addbutton = findViewById(R.id.AddBtn);
        listView = findViewById(R.id.listView);
        edit = findViewById(R.id.Edit);

        ScanButton.setOnClickListener(new View.OnClickListener() {
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

        Addbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String text  = edit.getText().toString();
            if(edit == null || edit.length()==0) {
                Toast.makeText(MainActivity.this, "Oops! ScanAgain...", Toast.LENGTH_SHORT).show();
            }else{
                addItem(text);
                edit.setText("");
                Toast.makeText(MainActivity.this, "Item is added " + text , Toast.LENGTH_SHORT).show();
            }
            }
        });

        // listView And ArrayAdapter

        ProductPrice = new ArrayList<>();

        ProductPrice.add("rs700");
        ProductPrice.add("rs600");
        ProductPrice.add("rs800");
        ProductPrice.add("rs500");
        // ArrayAdapter help to give this items to listView
         arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ProductPrice);
        // to set ArrayAdapter(array List) in listView
        listView.setAdapter(arrayAdapter);
    }
    public void addItem(String item){
        ProductPrice.add(item);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult intentResult = IntentIntegrator.parseActivityResult(
                requestCode, resultCode, data
        );
        edit.setText(intentResult.getContents());
        /*ProductPrice.add(intentResult.getContents());*/
        //***

        //check condition
        if (intentResult.getContents() != null) {
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
        }
        else{
            //when result content not null
            Toast.makeText(this, "opps try again", Toast.LENGTH_SHORT).show();
        }
    }
}
