package com.example.ramadanmubarak.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.ramadanmubarak.MagrifatFragment;
import com.example.ramadanmubarak.NajatFragment;
import com.example.ramadanmubarak.RahmatFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(@NonNull FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs=numberOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new RahmatFragment();
            case 1:
                return new MagrifatFragment();
            case 2:
                return new NajatFragment();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
