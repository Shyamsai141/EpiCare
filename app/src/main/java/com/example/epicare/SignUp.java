package com.example.epicare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        //TextView Cnpass = (TextView) findViewById(R.id.Cnpass);

        auth = FirebaseAuth.getInstance();

        Button SButton = (Button) findViewById(R.id.SButton);
        SButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String txt_email = email.getText().toString();
                    String txt_password = password.getText().toString();

                    if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                        Toast.makeText(SignUp.this, "Empty Details", Toast.LENGTH_SHORT).show();
                    }else if(txt_password.length() < 5){
                        Toast.makeText(SignUp.this, "password to short ", Toast.LENGTH_SHORT).show();
                    }else{
                        signupuser(txt_email , txt_password);
                    }

            }

            private void signupuser(String email, String password) {
                auth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful()){
                             Toast.makeText(SignUp.this, "Sign up Successful", Toast.LENGTH_SHORT).show();
                             openLogin();
                             finish();
                         }
                         else{
                             Toast.makeText(SignUp.this, "sorry! try later", Toast.LENGTH_SHORT).show();
                         }
                    }
                });
            }
        });
    }
    public void openLogin(){
        Intent intent = new Intent(this, Success.class);
        startActivity(intent);
    }
}