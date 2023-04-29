package com.example.datanotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         button = findViewById(R.id.button);
         editText = findViewById(R.id.editText);
         textView  = findViewById(R.id.text);
         button.setOnClickListener(new View.OnClickListener(){
             public void onClick(View v){

                 // this is shared preference file which names is demo in which there is one
                 // mode that is mode_private which help to private these file from
                 // the other applications
                 String msg =editText.getText().toString();
                 SharedPreferences srd = getSharedPreferences("demo" , MODE_PRIVATE);
                 SharedPreferences.Editor editor = srd.edit();
                 editor.putString("str",msg);
                 editor.apply();
                 textView.setText(msg);
             }

         });

         // get back the value from  shared preference
        SharedPreferences getshared = getSharedPreferences("demo" , MODE_PRIVATE);

        String value = getshared.getString("str" , "save a note and it will how you");
        textView.setText(value);


    }
}