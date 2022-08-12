package com.example.appsuckhoe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;



public class MainActivity extends AppCompatActivity {
    GoogleSignInClient mGoogleSignInClient;
    private static int RC_SIGN_IN = 100;
    Button btndangnhap;
    EditText edituser, editpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        ControlButton();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder( GoogleSignInOptions.DEFAULT_SIGN_IN )
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient( this, gso );

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount( this );
        SignInButton signInButton = findViewById( R.id.btndangnhap );
        signInButton.setSize( SignInButton.SIZE_STANDARD );
        signInButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        } );

    }

    private void ControlButton() {
        btndangnhap.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edituser.getText().toString();
                String pass = editpass.getText().toString();
                if (edituser.getText().toString().equals( "1906020127" ) && editpass.getText().toString().equals( "Vidok13" )) {
                    Toast.makeText( MainActivity.this, "Đăng Nhập Thành Công", Toast.LENGTH_LONG ).show();
                    Intent mh2 = new Intent( MainActivity.this, MenuActivity.class );
                    startActivity( mh2 );
                } else {
                    Toast.makeText( MainActivity.this, "Đăng Nhập Thất Bại", Toast.LENGTH_LONG ).show();
                }
            }
        } );

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult( signInIntent, RC_SIGN_IN );
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent( data );
            handleSignInResult( task );
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {

        try {
            GoogleSignInAccount account = completedTask.getResult( ApiException.class );
            GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount( this );
            if (acct != null) {
                String personName = acct.getDisplayName();
                String personGivenName = acct.getGivenName();
                String personFamilyName = acct.getFamilyName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                Uri imHinh = acct.getPhotoUrl();
                Toast.makeText( this, "User email:" + personEmail, Toast.LENGTH_LONG ).show();
                Intent intent = new Intent( MainActivity.this, MainActivity.class );
                intent.putExtra( "name", acct.getDisplayName() );
                intent.putExtra( "email", acct.getEmail() );
                startActivity( intent );
            }


            // Signed in successfully, show authenticated UI.
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d( "Message", e.toString() );
        }
    }
}
