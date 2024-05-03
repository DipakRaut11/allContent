package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        button = findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code for verification
                SharedPreferences preference = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.putBoolean("flag",true);
                editor.apply();

                Intent inext = new Intent(MainActivity2.this, HomeActivity.class);
                startActivity(inext);
            }
        });
    }
}