package com.example.fragmenttest;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmenttest.Fragment.HowTo;


public class MainActivity extends AppCompatActivity{

    private Context mContext;
    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();

        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_star_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_dashboard_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_volume_up_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_bluetooth_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_contact_support_black_48)));
//
        mViewPager = (ViewPager) findViewById(R.id.pager_content);
        mContentsPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mContentsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private View createTabView(int imgId){
        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab,null);
        ImageView Image_tab = (ImageView) tabView.findViewById(R.id.Image_tab);
        Image_tab.setBackgroundResource(imgId);
        return tabView;
    }
}

