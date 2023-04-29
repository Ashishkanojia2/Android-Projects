package com.example.androiddb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button insert,update,delete,View;
    DbHelper Db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1.findViewById(R.id.name);
        ed2.findViewById(R.id.Contact);
        ed3.findViewById(R.id.Dob);

        insert.findViewById(R.id.insertbtn);
        update.findViewById(R.id.updatebtn);
        delete.findViewById(R.id.deletebtn);
        View.findViewById(R.id.Viewbtn);
        Db= new DbHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String nameTXT = ed1.getText().toString();
                String contactTXT = ed2.getText().toString();
                String dobTXT = ed3.getText().toString();
                Boolean checkinsertdata = Db.insertuserdata(nameTXT,contactTXT,dobTXT);
                if(checkinsertdata==true){
                    Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Enter not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String nameTXT = ed1.getText().toString();
                String contactTXT = ed2.getText().toString();
                String dobTXT = ed3.getText().toString();
                Boolean checkupdateuserdata = Db.updateuserdata(nameTXT,contactTXT,dobTXT);
                if(checkupdateuserdata==true){
                    Toast.makeText(MainActivity.this, "Data is Updated ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data is not Updated ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String nameTXT = ed1.getText().toString();

                Boolean checkdeleteuserdata = Db.deleteuserdata(nameTXT);
                if(checkdeleteuserdata==true){
                    Toast.makeText(MainActivity.this, "Data is deleted ", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Data is not deleted ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Cursor res = Db.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+ res.getString(0)+"\n");
                    buffer.append("contact :"+ res.getString(1)+"\n");
                    buffer.append("dob :"+ res.getString(2)+"\n");

                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Enter");
                builder.setMessage(buffer.toString());
                builder.show();

            }
        });
    }
}