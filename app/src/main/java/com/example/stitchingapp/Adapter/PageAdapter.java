package com.example.stitchingapp.Adapter;

import android.app.Person;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.stitchingapp.Fragment.Home_Fragment;
import com.example.stitchingapp.Fragment.Person_Fragment;
import com.example.stitchingapp.Fragment.Saved_Fragment;

public class PageAdapter extends FragmentPagerAdapter {

    private final int totalTabs;

    public PageAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0)
            return new Home_Fragment();

        if (position == 1)
            return new Saved_Fragment();

        return new Person_Fragment();

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
