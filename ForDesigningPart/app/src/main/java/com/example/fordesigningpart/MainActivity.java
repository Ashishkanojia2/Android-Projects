package com.example.fordesigningpart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText textView;
    ListView listView;
    ArrayList<String>  items;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button2);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        items = new ArrayList<>();
       adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
       listView.setAdapter(adapter);



        button.setOnClickListener(new View.OnClickListener() {
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

    public Void additem(String item) {
        items.add(item);
        listView.setAdapter(adapter);
        return null;
    }

}