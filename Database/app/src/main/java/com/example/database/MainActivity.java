package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       MyDBHelper dbHelper = new MyDBHelper(MainActivity.this);

//       dbHelper.addContact("ABC", "3333");
//        dbHelper.addContact("weeee", "44444");
//        dbHelper.addContact("ddd", "66666");

        ArrayList<ContactModel> arrContacts = dbHelper.fetchContact();

//        ContactModel model = new ContactModel();
//        model.id = 1;
//        model.phone_no = "11111111";
//
//        dbHelper.update(model);


        dbHelper.deleteContact(2);
        dbHelper.deleteContact(3);

        for (int i = 0; i<arrContacts.size();i++){
            Log.d("COntact_Onfo ", "Name: "+arrContacts.get(i).name + ",phone_no: "
                    +arrContacts.get(i).phone_no
            );
        }


    }


}