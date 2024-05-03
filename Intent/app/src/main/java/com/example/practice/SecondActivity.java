package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent fromAct = getIntent();
        String title = fromAct.getStringExtra("title");
        String stdname = fromAct.getStringExtra("StdName");
       int Roll = fromAct.getIntExtra("Roll", 0);
       TextView txtStd;
       txtStd = findViewById(R.id.StdInfo);
       txtStd.setText("Roll "+Roll+", Name "+stdname);
       getSupportActionBar().setTitle(title);



    }
}