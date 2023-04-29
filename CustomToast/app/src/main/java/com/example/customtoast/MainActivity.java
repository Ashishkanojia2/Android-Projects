package com.example.customtoast;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      default toast
//        Toast.makeText(this, "message is sending", Toast.LENGTH_SHORT).show();
         //CustomToast

    /*button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    });*/
        // if we set this toast on button its shows error otherwise not

        Toast toast = new Toast(getApplicationContext());
        // inflater help to convert r.id(any name) into View
        View view =getLayoutInflater().inflate(R.layout.custom_toast_layout,(ViewGroup) findViewById(R.id.ViewContainer));   //(viewGroup) is called as typecast

        toast.setView(view);
        TextView txtmsg =view.findViewById(R.id.txtMsg);
        txtmsg.setText("Message send successfully!!");
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
        toast.setGravity(Gravity.TOP|Gravity.END,0,0);

        }

    }
