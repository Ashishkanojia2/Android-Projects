package com.example.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class ALregister extends AppCompatActivity {
    EditText ed1, ed2,ed3;
    Button btn;
    String emailpatten = "[a-zA-Z0-9_-]+@[a-z]+\\.+[a-z]+";
    String usernamepatten = "[a-zA-Z0-9_-]+\\.+[a-z]+";
   /* String passwordpatten = "[a-zA-Z0-9_-]+[a-z]+";*/
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alregister);
        ed1.findViewById(R.id.edit1);
        ed1.findViewById(R.id.edit2);
        ed1.findViewById(R.id.edit3);
        btn = findViewById(R.id.loginbtn);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        progressDialog = new ProgressDialog(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforAuth();
            }
        });
    }
        private void perforAuth() {
            String username = ed3.getText().toString();
            String email = ed1.getText().toString();
            String password = ed2.getText().toString();

            if (email.matches(emailpatten)) {
                Toast.makeText(ALregister.this, "Your Email is Correct ", Toast.LENGTH_SHORT).show();
                if (username.matches(usernamepatten)) {
                    Toast.makeText(ALregister.this, "Your Username is Correct", Toast.LENGTH_SHORT).show();
                    if (password.matches(password)) {
                        Toast.makeText(ALregister.this, "Your Password is Correct", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(ALregister.this, "Error In Password", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ALregister.this, "Please Enter Correct UserName ", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(ALregister.this, "Enter Valid EMAIL", Toast.LENGTH_SHORT).show();
            }
            progressDialog.setMessage("Please wait while Registration");
            progressDialog.setTitle("REGISTRATION....");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();

                        Toast.makeText(ALregister.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(ALregister.this,SecondScreen.class);
                        // if user successfully registred they came back
                        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(ALregister.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
