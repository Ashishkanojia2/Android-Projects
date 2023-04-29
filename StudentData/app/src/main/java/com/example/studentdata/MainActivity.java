package com.example.studentdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btn;
    Spinner spinner;
     DatabaseReference studentDatabaseRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1.findViewById(R.id.user);
        e2.findViewById(R.id.pass);
        btn.findViewById(R.id.button);
        spinner.findViewById(R.id.spin);

        studentDatabaseRef = FirebaseDatabase.getInstance().getReference().child("studentFile");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertStudentdata();
            }
        });

    }
    private void insertStudentdata(){
        String name = e1.getText().toString();
        String pass = e2.getText().toString();
        String cource = spinner.getSelectedItem().toString();
        students student = new students(name,pass,cource);
        studentDatabaseRef.push().setValue(student);
        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();

    }
}