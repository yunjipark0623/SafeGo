package com.example.fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fragmenttest.Fragment.HowTo;


public class MainActivity extends AppCompatActivity{

        private Context mContext;
        private TabLayout mTabLayout;

        private ViewPager mViewPager;
        private ContentsPagerAdapter mContentsPagerAdapter;

//        public void nine(View v) {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.segway.com/media/1959/25265-00001_ac-one-s1-um_en_web.pdf"));
//        }
//
//        public void mini(View v) {
//            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.segway.com/media/2271/25521-00001_ab-miniplus-user-manual-en.pdf"));
//        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            mContext = getApplicationContext();

            mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("작동법")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("대쉬보드")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("경 적")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("블루투스")));
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView("고객센터")));
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
            private View createTabView(String tabName){
                View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab,null);
                TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);
                txt_name.setText(tabName);
                return tabView;
        }
    }


