package com.example.alertdialogbox;

import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog alert = new AlertDialog.Builder(this).create();     // this is create method for one button dialog box
        alert.setTitle("Terms & Conditions");
        alert.setIcon(R.drawable.info);
        alert.setMessage("have you read terms and conditions");
        alert.setButton(-3 , "yes ", new DialogInterface.OnClickListener() {    // which button means Positions of the button its mens they will shown in which side right side b or left side (-1,-3)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "OK DONE", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
        // now we create two button dialog box so, we cant to create a create method we directly use builder class object .

        AlertDialog.Builder deleteBox = new AlertDialog.Builder(MainActivity.this);
        deleteBox.setTitle("Delete this message");
        deleteBox.setIcon(R.drawable.delete_icone);
        deleteBox.setMessage("Are You Sure To Delete This Message ");
        deleteBox.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Message is deleted", Toast.LENGTH_SHORT).show();
            }
        });
        deleteBox.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Message is not Deleted ", Toast.LENGTH_SHORT).show();
            }
        });
        deleteBox.setNeutralButton("Cancle ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        deleteBox.show();


    }

    @Override
    public void onBackPressed() {           // on pressing back button in mobile 
      AlertDialog.Builder exit = new AlertDialog.Builder(this);
      exit.setTitle("Exit App");
      exit.setIcon(R.drawable.ic_baseline_exit_to_app_24);
      exit.setMessage("Are you sure to exit this app");

      exit.setPositiveButton("YES ", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
              MainActivity.super.onBackPressed();
          }
      });
      exit.setNegativeButton("NO", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialogInterface, int i) {
              Toast.makeText(MainActivity.this, "Welcome back sir", Toast.LENGTH_SHORT).show();
          }
      });
        exit.show();

    }
}