package com.example.alertdialogbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//For single button
        /*
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Terms and Conditions");
        alertDialog.setIcon(R.drawable.baseline_access_time_24);
        alertDialog.setMessage("Have you Read all terms and Conditions");

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "yes, I've Read", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You can Proceed now", Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.show();

         */


        //For 2 or 3 button
/*
        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
        delDialog.setTitle("Delete?");
        delDialog.setIcon(R.drawable.baseline_delete_24);
        delDialog.setMessage("Are you sure you want to delete");

        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Item deleted",Toast.LENGTH_SHORT).show();
            }
        });

        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Item not deleted",Toast.LENGTH_SHORT).show();
            }
        });

        delDialog.show();

 */


    }

    @Override
    public void onBackPressed() {
      
        AlertDialog.Builder exitDialog = new AlertDialog.Builder(MainActivity.this);
        exitDialog.setTitle("Exit?");
        exitDialog.setIcon(R.drawable.baseline_exit_to_app_24);
        exitDialog.setMessage("Are you sure you want to exit");

        exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
            }
        });

        exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Call super method to handle back press
                MainActivity.super.onBackPressed();
            }
        });

        exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Operation Cancelled", Toast.LENGTH_SHORT).show();
            }
        });
        exitDialog.show();
    }

}
