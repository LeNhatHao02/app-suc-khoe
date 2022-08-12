package com.example.appsuckhoe;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super( fm, behavior );
        tabcount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
       switch (position)
       {
           case 0:
               return  new Homefragment();
           case 1:
               return  new Healthfragment();
           case 2:
               return  new Medicalfragment();
           case 3:
               return  new Covidfragment();
           case 4:
               return  new Vacxinfragment();

           default:
               return null;
       }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
