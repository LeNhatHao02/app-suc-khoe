package com.example.appsuckhoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    TextView tvTrangchu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_menu );

        tvTrangchu = findViewById(R.id.tvTintuc);
        tvTrangchu.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {navigateToTintucActivity();}
        } );
    }

    private void navigateToTintucActivity() {
        Intent intent = new Intent( MenuActivity.this, TintucActivity.class);
        startActivity(intent);
    }
}