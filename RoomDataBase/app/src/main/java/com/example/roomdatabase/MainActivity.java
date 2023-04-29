package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2;
    Button b1;
//    TextView txt1,txt2,txt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        b1 = findViewById(R.id.b1);
//        txt1 = findViewById(R.id.txt1);
//        txt2 = findViewById(R.id.txt2);
//        txt3 = findViewById(R.id.txt3);

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
         new bgthread().start();
        }
    });

    }

    class  bgthread  extends Thread{
        @Override
        // run method is used to run all those  query what i want
        public void run() {
            // object of dataBase
            AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "room_database").build();
            // object of room interface
            UserDao userDao = db.userDao();
            // to all insert method from interface
            userDao.insertAll(new User(1,t1.getText().toString(),t2.getText().toString()));
            t1.setText("");
            t2.setText("");


            super.run();

        }
    }
}