package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView txtAnmi;
Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAnmi= findViewById(R.id.textView2);
        btn1 = findViewById(R.id.Alpha);
        btn2 = findViewById(R.id.Translate);
        btn3 = findViewById(R.id.Rotate);
        btn4 = findViewById(R.id.Scale);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation move = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move_animation);

                //txtAnmi.setAnimation(); //start only one time
                txtAnmi.startAnimation(move);// when we need animation every time it animate
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation alfa = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                txtAnmi.startAnimation(alfa);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation rotation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotation);
                txtAnmi.startAnimation(rotation);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation scale = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                txtAnmi.startAnimation(scale);
            }
        });
    }
}