package com.example.appsuckhoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class TintucActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, mhealth, mcovid, mmedical, mvacxin;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    TextView tvHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tintuc );

        mtoolbar = findViewById( R.id.toolbar );
        setSupportActionBar( mtoolbar );

        mhome = findViewById( R.id.home );
        mhealth = findViewById( R.id.health );
        mcovid = findViewById( R.id.covid );
        mmedical = findViewById( R.id.medical );
        mvacxin = findViewById( R.id.vacxin );
        ViewPager viewPager = findViewById( R.id.framentcontainer );
        tabLayout = findViewById( R.id.included );
        tvHome = findViewById(R.id.tvTrangchu);
        tvHome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMenuActivity();
            }
        } );

        pagerAdapter = new com.example.appsuckhoe.PagerAdapter(getSupportFragmentManager(), 6 );

        viewPager.setAdapter( pagerAdapter );

        tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem( tab.getPosition() );
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        } );
        viewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );
    }

    private void navigateToMenuActivity() {
        finish();
        Intent intent = new Intent(TintucActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void setSupportActionBar(Toolbar mtoolbar) {
    }
}
    