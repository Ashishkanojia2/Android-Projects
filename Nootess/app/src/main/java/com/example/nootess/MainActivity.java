package com.example.nootess;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatActivity;

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



public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText Emailid;
    EditText pass;
    Button go_to_next;
    String EmailValidation;
    ProgressDialog progressDialog;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Emailid = findViewById(R.id.Emailid);
        pass = findViewById(R.id.pass);
        go_to_next = findViewById(R.id.go_to_next);
        progressDialog = new ProgressDialog(this);
        EmailValidation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


        go_to_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performeLogin();


            }
        });

    }

    private void performeLogin() {
        String Em = Emailid.getText().toString();
        String Pas = pass.getText().toString();

        if (!Em.matches(EmailValidation)) {
            Emailid.setError("Please Enter the correct email");
        } else if (Pas.isEmpty()) {
            pass.setError("Please Enter the Password");
        } else if (Pas.length() < 6) {
            pass.setError("Your Password is too small");
        } else {
            progressDialog.setMessage("Please wait for Login.....");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(Em,Pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(MainActivity.this, "Registration is Successful", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(MainActivity.this, ""+ task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(MainActivity.this,MainScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}

