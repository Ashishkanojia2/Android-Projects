package com.example.nootess;

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
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    EditText emailid ;
    EditText password ;
    EditText confirmpassword ;
    Button createAc ;
    String EmailValidation ;
        ProgressDialog progressDialog;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailid = findViewById(R.id.CreateEmailid);
        password = findViewById(R.id.Createpass);
        confirmpassword = findViewById(R.id.Confirmpass);
        createAc = findViewById(R.id.CreateAccount);
        progressDialog = new ProgressDialog(this);
        EmailValidation ="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
try {
    createAc.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            performAuth();
        }
    });
}catch(Exception e){
    System.out.println(e);
    Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
}
    }

    private void performAuth() {
        String Em = emailid.getText().toString();
        String Pas = password.getText().toString();
        String Cpas = confirmpassword.getText().toString();

        if(!Em.matches(EmailValidation)){
            emailid.setError("Please Enter the correct email");
        }else if(Pas.isEmpty()){
            password.setError("Please Enter the Password");
        }else if(  Pas.length()<6){
            password.setError("Your Password is too small");
        }else if(!Pas.equals(Cpas)){
            password.setError("Password doesn't match");
        }else{
            progressDialog.setMessage("Please wait for Registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(Em,Pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   progressDialog.dismiss();
                   sendUserToNextActivity();
                   Toast.makeText(LoginActivity.this, "Registration is Successful", Toast.LENGTH_SHORT).show();
               }else{
                   progressDialog.dismiss();
                   Toast.makeText(LoginActivity.this, ""+ task.getException(),Toast.LENGTH_SHORT).show();
               }
                }
            });
        }

    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(LoginActivity.this,MainScreen.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

}