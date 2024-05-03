
/*package com.example.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);

        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Tool Bar");
            getSupportActionBar().setSubtitle("Hello");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();


        switch (itemId) {
            case R.id.opt_new:
                showToast("New option selected");
                return true;
            case R.id.opt_open:
                showToast("Open option selected");
                return true;
            case R.id.opt_save:
                showToast("Save option selected");
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}*/






package com.example.customtoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);

      /*  setSupportActionBar(); use it for appcompact toolbar
        setActionBar(); use it for normal toolbar*/

    //setup
   // setSupportActionBar(toolbar);

    //customization
    // it is by default given by androidstudio or we can alo customize in xml


   // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //if setup is not done ie         setSupportActionBar(toolbar);

//
        if (getSupportActionBar()!=null){

             getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My tool Bar");
       }
       // or use try catch



        toolbar.setSubtitle("Hello");




        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
        }

@Override
public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itmeID = item.getItemId();
        if (itmeID == R.id.opt_new){
        Toast.makeText(this, "New option", Toast.LENGTH_SHORT).show();
        }
        else if (itmeID == R.id.opt_open) {
        Toast.makeText(this, "Open file", Toast.LENGTH_SHORT).show();
        }
        else if (itmeID == R.id.opt_save) {
        Toast.makeText(this, "File Save", Toast.LENGTH_SHORT).show();
        }
        /*BAck id given by android
        we cann use ef else of put only in else
         */
        else if (itmeID == android.R.id.home) {
        super.onBackPressed();
        }
        else {

        }

        return super.onOptionsItemSelected(item);
        }
}


