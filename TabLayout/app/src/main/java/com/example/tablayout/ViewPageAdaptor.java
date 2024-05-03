package com.example.tablayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPageAdaptor extends FragmentPagerAdapter {

    public ViewPageAdaptor(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPageAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }





    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new BlankFragment();
        }
        else if (position == 1) {
            return new BlankFragment2();

        }
        else {
            return  new BlankFragment3();
        }

    }

    @Override
    public int getCount() {
        return 3; //no of tabs
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return "Hello";
        }
        else if (position == 1) {
            return "How";

        }
        else {
            return  "How are you";
        }

    }
}
