package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    String ROOT_FRAGMENT_TAG = "root_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);


        //default fragment
        fragment(new BlankFragment(), 0);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             fragment(BlankFragment.getInstance("DDD",6), 1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              fragment(new BlankFragment2(), 1);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             fragment(new BlankFragment3(), 1);
            }
        });
    }

    public void fragment(Fragment fragment, int flag){
        //it is internal call or service call so we use get means getting referencer from activity we use get
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

//        Bundle bundle = new Bundle();
//        bundle.putString("Arg1","Hello");
//        bundle.putInt("Arg2", 4);
//
//        fragment.setArguments(bundle);


        if (flag ==0) {
            ft.add(R.id.container, fragment);
            fm.popBackStack(ROOT_FRAGMENT_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(ROOT_FRAGMENT_TAG);

        }
        else{
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }

        ft.commit();
    }
}