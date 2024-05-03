package com.example.roomlibrarydb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editName, editAmount;
    Button next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editAmount = findViewById(R.id.edtAmount);
        editName = findViewById(R.id.edtNmae);
        next_btn = findViewById(R.id.click_btn);

        dbHelper dbhelper = dbHelper.getDB(this); //it is static method so new is not required


        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = editName.getText().toString();
                String amount = editAmount.getText().toString();
                dbhelper.expenseDao().addTransaction(
                        new Expense(title, amount)


                );
                ArrayList<Expense> arrExpenses = (ArrayList<Expense>) dbhelper.expenseDao().getAllExpenses();

                for (int i = 0;i<arrExpenses.size();i++){

                    Log.d("Data", "Title: "+arrExpenses.get(i).getTitle() + " Amount: "+arrExpenses.get(i).getAmount());
                }
            }
        });




    }
}