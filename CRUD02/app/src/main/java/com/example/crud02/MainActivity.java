package com.example.crud02;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btnDelete,btnView,btnUpdate;
    EditText ed1,ed2,ed3;
    dataBase dbase = new dataBase(this );
    SQLiteDatabase sq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SQLiteDatabase db1 = dbase.getWritableDatabase();
        /*setContentView(R.layout.activity_main);*/
        btn1 = findViewById(R.id.btnInsert);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.update);
        btnView = findViewById(R.id.view);
        ed1 = findViewById(R.id.name);
        ed3 = findViewById(R.id.password);
        ed2 = findViewById(R.id.username);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = ed1.getText().toString();
                String username2  = ed2.getText().toString();
                String password3 = ed3.getText().toString();

                if(name1.equals("")|| username2.equals("")|| password3.equals("")){
                    Toast.makeText(MainActivity.this, "Something is Error", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean i = dbase.insert_data(name1,username2,password3);
                    if(i== true){
                        Toast.makeText(MainActivity.this, "sucessfull ", Toast.LENGTH_SHORT).show();
                        
                    }else{
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}