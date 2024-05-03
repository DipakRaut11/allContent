package com.example.listviewspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    Spinner spinners;
    AutoCompleteTextView auto;
    int[] num = new int[]{1,2,3,4,5};
    ArrayList<String> arrName = new ArrayList<>();
    ArrayList<String> arrids = new ArrayList<>();
    ArrayList<String> autoComp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        spinners = findViewById(R.id.spinner);
        auto = findViewById(R.id.auto);


        arrName.add("Dipak");
        arrName.add("Kumar");
        arrName.add("Raut");
        arrName.add("Kartik");
        arrName.add("Dipak");
        arrName.add("Dipak");
        arrName.add("Kumar");
        arrName.add("Raut");
        arrName.add("Kartik");
        arrName.add("Dipak");
        arrName.add("Dipak");
        arrName.add("Kumar");
        arrName.add("Raut");
        arrName.add("Kartik");
        arrName.add("Dipak");
        arrName.add("Dipak");
        arrName.add("Kumar");
        arrName.add("Raut");
        arrName.add("Kartik");
        arrName.add("Dipak");
        arrName.add("Dipak");
        arrName.add("Kumar");
        arrName.add("Raut");
        arrName.add("Kartik");
        arrName.add("Dipak");
        arrName.add("Dipak");
        arrName.add("Kumar");
        arrName.add("Raut");
        arrName.add("Kartik");
        arrName.add("Dipak");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,arrName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(MainActivity.this, "Its me raut",Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(MainActivity.this, "Its me dipak",Toast.LENGTH_SHORT).show();
                }
            }
        });



        //spinner = findViewById(R.id.spinner);

        arrids.add("abcs0");
        arrids.add("dddd9");
        arrids.add("whjfruith4");
        arrids.add("aaddjkbh444");arrids.add("abcs0");
        arrids.add("dddd9");
        arrids.add("whjfruith4");
        arrids.add("aaddjkbh444");arrids.add("abcs0");
        arrids.add("dddd9");
        arrids.add("whjfruith4");
        arrids.add("aaddjkbh444");arrids.add("abcs0");
        arrids.add("dddd9");
        arrids.add("whjfruith4");
        arrids.add("aaddjkbh444");

        ArrayAdapter<String> SpinnerAdopter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,arrids);
        spinners.setAdapter(SpinnerAdopter);

        autoComp.add("Nepali");
        autoComp.add("English");
        autoComp.add("Hindi");
        autoComp.add("Japanese");
        autoComp.add("Korean");
        autoComp.add("Germaney");
        ArrayAdapter<String > actvAdopter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,autoComp);
        auto.setAdapter(actvAdopter);
        auto.setThreshold(2);

    }
}