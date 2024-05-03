package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
TabLayout tab;
ViewPager viewPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tab = findViewById(R.id.tabLayout);
        viewPage = findViewById(R.id.viewPage);


        ViewPageAdaptor adaptor = new ViewPageAdaptor(getSupportFragmentManager());
        viewPage.setAdapter(adaptor);
        tab.setupWithViewPager(viewPage);
    }
}