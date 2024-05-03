package com.example.cruderecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<contact> arrContact = new ArrayList<>();
    RecycleViewAdeptor adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView = findViewById(R.id.RecycleContact);
        FloatingActionButton btnDialog = findViewById(R.id.btnOpenDialog);


        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update);

                EditText addName, addContact;
                Button addButton;
                addName = dialog.findViewById(R.id.updateName);
                addContact = dialog.findViewById(R.id.updateContact);
                addButton = dialog.findViewById(R.id.UpdateButton);

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = addName.getText().toString();
                        String number = addContact.getText().toString();

                        if (name.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
                            return; // Exit the method if name is empty
                        }

                        if (addContact.getText().toString().equals("")) {
                            number = addContact.getText().toString();
                        }
                        else {
                            Toast.makeText(MainActivity.this,"ENter Number", Toast.LENGTH_SHORT).show();
                        }

                        arrContact.add(new contact(R.drawable.ic_launcher_foreground,name, number));
                        adapter.notifyItemInserted(arrContact.size() - 1);
                        recyclerView.scrollToPosition(arrContact.size() - 1);
                        dialog.dismiss(); // Dismiss the dialog after adding the contact
                    }
                });

                dialog.show();
            }
        });


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
        //or
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"yyyy","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"kkkk","666"));
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"yyyy","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"kkkk","666"));
        arrContact.add(new contact(R.drawable.ic_launcher_foreground,"yyyy","9999"));
        arrContact.add(new contact(R.drawable.ic_launcher_background,"kkkk","666"));

        adapter = new RecycleViewAdeptor(this,arrContact);
        recyclerView.setAdapter(adapter);
    }
}