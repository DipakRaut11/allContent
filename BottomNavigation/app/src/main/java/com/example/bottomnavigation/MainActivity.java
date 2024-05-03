package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.buttomNavigation);

        bnView.setSelectedItemId(R.id.setting);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();


                if (id == R.id.nav_home){
                    fragment(new BlankFragment(),false);
                }
                else if (id == R.id.setting) {
                    fragment(new BlankFragment2(), false);
                }
                else if (id == R.id.back) {
                    fragment(new BlankFragment3(), false);
                }
                else if (id == R.id.forhead) {
                    fragment(new BlankFragment4(), false);
                }
                else {
                    //(id == R.id.nav_search)
                    fragment(new BlankFragment5(), true);
                }

               return true;
            }
        });

    }
    public void fragment(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag ){
            ft.add(R.id.container, fragment);
        }
        else {
            ft.replace(R.id.container, fragment);
        }
        ft.commit();

    }
}