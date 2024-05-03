package com.example.viewcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
CardView card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        card = findViewById(R.id.Card);

        /*card.setRadius(4.0f);
        card.setCardElevation(10.0f);
        card.setUseCompatPadding(true);*/
    }
}