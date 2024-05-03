package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactModel> arrContact = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecycleContact);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ContactModel model = new ContactModel(R.drawable.ic_launcher_background,"aa","999");
        arrContact.add(model);
        //or
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"fff","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(model);
        //or
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"fff","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(model);
        //or
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"yoyoy","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"pfpfdk","666"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"fff","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"ffrrf","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"dd","666"));
        arrContact.add(model);
        //or
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"yyyy","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"kkkk","666"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"yyyy","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"kkkk","666"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_foreground,"yyyy","9999"));
        arrContact.add(new ContactModel(R.drawable.ic_launcher_background,"kkkk","666"));

        RecycleContactAdapter adapter = new RecycleContactAdapter(this,arrContact);
        recyclerView.setAdapter(adapter);
    }
}