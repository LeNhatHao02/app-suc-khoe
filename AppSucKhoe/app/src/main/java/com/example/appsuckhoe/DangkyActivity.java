package com.example.appsuckhoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class DangkyActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextHovaten, editTextCCCD, editTextTramyte, editTextmatkhau, editTextsdt, editTextTiensu;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    Button dangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dangky );
        mAuth = FirebaseAuth.getInstance();
        editTextHovaten = (EditText) findViewById( R.id.tvhovaten );
        editTextCCCD = (EditText) findViewById( R.id.tvCCCD );
        editTextTramyte = (EditText) findViewById( R.id.tvtramyte );
        editTextmatkhau = (EditText) findViewById( R.id.tvmatkhau );
        editTextsdt = (EditText) findViewById( R.id.tvsdt );
        editTextTiensu = (EditText) findViewById( R.id.tvtiensubenh );
        progressBar = (ProgressBar) findViewById( R.id.progressBar );
        dangky.setOnClickListener( this );


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btndangki:
                dangky();
                break;
        }
    }

    private void dangky() {
        String Hovaten = editTextHovaten.getText().toString().trim();
        String CCCD = editTextCCCD.getText().toString().trim();
        String Tramyte = editTextTramyte.getText().toString().trim();
        String Matkhau = editTextmatkhau.getText().toString().trim();
        String sdt = editTextsdt.getText().toString().trim();
        String Tiensu = editTextsdt.getText().toString().trim();

        if (Hovaten.isEmpty()) {
            editTextHovaten.setError( "Ho va ten sai" );
            editTextHovaten.requestFocus();
            return;
        }
        if (CCCD.isEmpty()) {
            editTextCCCD.setError( "CCCD khong dung!" );
            editTextCCCD.requestFocus();
            return;
        }
        if (Tramyte.isEmpty()) {
            editTextTramyte.setError( "Tram y te khong dung!" );
            editTextTramyte.requestFocus();
            return;
        }
        if (Matkhau.isEmpty()) {
            editTextmatkhau.setError( "Sai mat khau!" );
            editTextmatkhau.requestFocus();
            return;
        }
        if (sdt.length() <11) {
            editTextsdt.setError( "SDT khong ton tai!" );
            editTextsdt.requestFocus();
            return;
        }
        if (Tiensu.isEmpty()) {
            editTextTiensu.setError( "Sai ten !" );
            editTextTiensu.requestFocus();
            return;

        }
        if (CCCD.length() < 12){
            editTextCCCD.setError("Khong tim thay CCCD!");
            editTextCCCD.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(CCCD, Matkhau )
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user = new User(Hovaten, CCCD, Matkhau, Tramyte, sdt, Tiensu );

                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener( new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText( DangkyActivity.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                                Intent intent = new Intent( DangkyActivity.this, MainActivity.class);
                                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                                startActivity(intent);
                                            }else {
                                                Toast.makeText( DangkyActivity.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    } );

                        }else {
                            Toast.makeText( DangkyActivity.this, "Failed to register! Try again", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                } );


    }
}