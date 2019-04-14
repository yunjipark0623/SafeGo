package com.example.fragmenttest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.fragmenttest.Fragment.MondayFragment;
import com.example.fragmenttest.Fragment.TueFragment;

public class MainActivity extends AppCompatActivity {

    PagerAdapter pagerAdapter;
    TabLayout tl;
    ViewPager vp;
    FragmentTransaction ft;
    FragmentManager fm;
    Fragment fragment;
    //int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl=findViewById(R.id.tabLayout);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        vp=(ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(pagerAdapter);
        vp.setOnClickListener(this);

    }
}

