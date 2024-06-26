package com.example.stitchingapp;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.stitchingapp.Adapter.PageAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);


        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.Home)).setIcon(R.drawable.baseline_home_24));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.Saved)).setIcon(R.drawable.baseline_star_24));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.Profile)).setIcon(R.drawable.person));

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null && tab.getIcon() != null) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.white);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
        }

        PagerAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.green);
                if (tab.getIcon() != null) {
                    tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.white);
                if (tab.getIcon() != null) {
                    tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.green);
        TabLayout.Tab selectedTab = tabLayout.getTabAt(tabLayout.getSelectedTabPosition());
        if (selectedTab != null && selectedTab.getIcon() != null) {
            selectedTab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
        }
    }
}
