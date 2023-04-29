package com.example.tablex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
       TextView textView;
       ListView listView;
       SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       textView = findViewById(R.id.textView);
       listView = findViewById(R.id.listView);
       seekBar = findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(MainActivity.this, "Populating table of  " + progress, Toast.LENGTH_SHORT).show();
                populate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });             //        ******************    there is one error in this code which is line no 50  last
                        //        ******************    word multable is cannot resolve


        }
    public void  populate(int table){
        ArrayList<String> multable = new ArrayList<>();
        for (int i=1; i<=10 ; i++){
            multable.add(table + " X " + i + " = " + table*i);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1.multable);
        listView.setAdapter(arrayAdapter);
    }
}






