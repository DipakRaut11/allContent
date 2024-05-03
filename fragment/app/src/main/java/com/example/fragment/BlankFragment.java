package com.example.fragment;

import android.os.Bundle;

//this class is used internet is connected
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    private static final String argy1 = "argument1";
    private static final String argy2 = "argument2";

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment getInstance(String value1, int value2){
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(argy1,value1);
        bundle.putInt(argy2, value2);
        blankFragment.setArguments(bundle);

        return blankFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments()!= null){
          String name =   getArguments().getString("argy1");
          int roll = getArguments().getInt("argy2");

            Log.d("VAlue are ","name is:"+name+ " Roll is "+roll);

        }

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_blank, container, false);
        TextView txt1 = view.findViewById(R.id.txt1);


        return  view;
    }
}