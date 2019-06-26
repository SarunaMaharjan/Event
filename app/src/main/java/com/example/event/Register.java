package com.example.event;



import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity implements View.OnClickListener {
    private TextView Register, Sign;
    private EditText Username, Email, Password;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {

            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        progressDialog = new ProgressDialog(this);


        Register = (TextView) findViewById(R.id.register);
        Register.setOnClickListener( this);

        Register = (TextView) findViewById(R.id.register);
        Sign = (TextView) findViewById(R.id.already);
        Username = (EditText) findViewById(R.id.username);
        Password = (EditText) findViewById(R.id.password);
        Email = (EditText) findViewById(R.id.email);

        Register.setOnClickListener( this);
        Sign.setOnClickListener( this);
    }

    private void registerUser() {
        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();
        String username = Username.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registration process on progress....");
        progressDialog.show();

        Runnable progressRunnable = new Runnable() {

            @Override
            public void run() {
                progressDialog.cancel();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(progressRunnable, 800);


        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "REGISTRATION COMPLETE", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        }
                        else {
                            Toast.makeText(Register.this, "FAILED....PLEASE TRY AGAIN", Toast.LENGTH_SHORT).show();
                            Toast.makeText(Register.this, "PASSWORD NOT STRONG", Toast.LENGTH_SHORT).show();

                        }


                    }
                });


    }


    public void onClick(View view) {

        //startActivity(new Intent(this,HomePage.class));
        if (view == Register) {
            registerUser();
        }

        if (view == Sign) {
            startActivity(new Intent(this, Login.class));

        }
    }


}
