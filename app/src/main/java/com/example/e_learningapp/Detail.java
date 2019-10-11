package com.example.e_learningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {
    List<String> mTitle;
    List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        String content = intent.getStringExtra("com.example.e_learningapp.SOMETHING");

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("课程信息"));
        tabLayout.addTab(tabLayout.newTab().setText("教学大纲"));
        tabLayout.addTab(tabLayout.newTab().setText("教学日历"));

        mFragment = new ArrayList<>();
        mFragment.add(new contentFragment(content+"课程信息"));
        mFragment.add(new contentFragment("教学大纲"));
        mFragment.add(new contentFragment("教学日历"));



        mTitle = new ArrayList<>();
        mTitle.add("课程信息");
        mTitle.add("教学大纲");
        mTitle.add("教学日历");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragment.get(position);
            }

            @Override
            public int getCount() {
                return mFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitle.get(position);
            }



        });

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(3);
    }
}
