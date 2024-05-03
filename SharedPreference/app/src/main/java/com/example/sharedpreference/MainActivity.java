package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preference = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check =  preference.getBoolean("flag",false);
                Intent inext;

                if(check){//for true (user is loffed in)
                    inext = new Intent(MainActivity.this, HomeActivity.class);
                }
                else {// for fale (either for first time or user is loggedout)
                    inext = new Intent(MainActivity.this, MainActivity2.class);
                }
                startActivity(inext);
            }
        },1000);
    }
}