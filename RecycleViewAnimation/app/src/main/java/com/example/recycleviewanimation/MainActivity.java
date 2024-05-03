package com.example.recycleviewanimation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<contact> arrContact = new ArrayList<>();
    RecycleViewAdaptor adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.RecycleContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        contact model = new contact(R.drawable.ic_launcher_background,"aa","999");
        arrContact.add(model);
        //or
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"fff","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(model);
        //or
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"fff","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(model);
        //or
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"yoyoy","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"pfpfdk","666"));
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"fff","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"ffrrf","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(model);

        adapter = new RecycleViewAdaptor(this,arrContact);
        recyclerView.setAdapter(adapter);
    }
}