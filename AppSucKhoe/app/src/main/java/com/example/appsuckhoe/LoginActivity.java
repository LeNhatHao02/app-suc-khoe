package com.example.appsuckhoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
        private EditText editTextcccd, editTextmatkhau;
        TextView tvSignin;
        Button registerUser, btnRegister;
        private FirebaseAuth mAuth;
        private ProgressBar progressBar;


        public LoginActivity() {
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_login );
            mAuth = FirebaseAuth.getInstance();
            registerUser = (Button) findViewById( R.id.btndangnhap );
            editTextcccd = (EditText) findViewById( R.id.edtCCCD );
            editTextmatkhau = (EditText) findViewById( R.id.edtMatKhau );
            progressBar = (ProgressBar) findViewById( R.id.progressBar );
            registerUser.setOnClickListener( this );
            tvSignin = findViewById( R.id.tvDangnhap );

            tvSignin.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    navigateToLoginActivity();
                }

                private void navigateToLoginActivity() {
                    finish();
                    Intent intent = new Intent( LoginActivity.this, MenuActivity.class );
                    startActivity( intent );
                }
            } );

        }

        @Override
        public void onClick(@NonNull View v) {
            switch (v.getId()) {
                case R.id.btndangnhap:
                    registerUser();
                    break;
            }

        }

        private void registerUser() {
            String cccd = editTextcccd.getText().toString().trim();
            String matkhau = editTextmatkhau.getText().toString().trim();

            if (cccd.isEmpty()) {
                editTextcccd.setError( "Name is required!" );
                editTextcccd.requestFocus();
                return;
            }
            if (matkhau.isEmpty()) {
                editTextmatkhau.setError( "Password is required!" );
                editTextmatkhau.requestFocus();
                return;
            }
            if (matkhau.length() < 6) {
                editTextmatkhau.setError( "Min password length should be 6 characters!" );
                editTextmatkhau.requestFocus();
                return;
            }

            progressBar.setVisibility( View.VISIBLE );
            mAuth.createUserWithEmailAndPassword( cccd, matkhau )
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User user = new User(cccd,matkhau);

                                FirebaseDatabase.getInstance().getReference( "User" )
                                        .child( FirebaseAuth.getInstance().getCurrentUser().getUid() )
                                        .setValue( user ).addOnCompleteListener( new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText( LoginActivity.this, "User has been registered successfully", Toast.LENGTH_LONG ).show();
                                                    progressBar.setVisibility( View.GONE );
                                                    Intent intent = new Intent( LoginActivity.this, MenuActivity.class );
                                                    intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
                                                    startActivity( intent );
                                                } else {
                                                    Toast.makeText( LoginActivity.this, "Failed to register! Try again", Toast.LENGTH_LONG ).show();
                                                    progressBar.setVisibility( View.GONE );
                                                }
                                            }
                                        } );

                            } else {
                                Toast.makeText( LoginActivity.this, "Failed to register! Try again", Toast.LENGTH_LONG ).show();
                                progressBar.setVisibility( View.GONE );
                            }
                        }
                    } );


        }
    }