package com.example.fragmenttest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.SystemClock;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fragmenttest.Fragment.HowTo;

import java.text.BreakIterator;


public class MainActivity extends AppCompatActivity{

    private static Data data;
    private Context mContext;
    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentsPagerAdapter;
    Data.OnGpsServiceUpdate onGpsServiceUpdate;
    private TextView maxSpeed, averageSpeed, distance;
    private SharedPreferences sharedPreferences;
    private Chronometer time;


    public static Data getData() {
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
        setfragement();


//        test2();
    }

    private void test2() {
        time.setText("00:00:00");
        time.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            boolean isPair = true;
            @Override
            public void onChronometerTick(Chronometer chrono) {
                long time;
                if(data.isRunning()){
                    time= SystemClock.elapsedRealtime() - chrono.getBase();
                    data.setTime(time);
                }else{
                    time = data.getTime();
                }

                int h   = (int)(time /3600000);
                int m = (int)(time  - h*3600000)/60000;
                int s= (int)(time  - h*3600000 - m*60000)/1000 ;
                String hh = h < 10 ? "0"+h: h+"";
                String mm = m < 10 ? "0"+m: m+"";
                String ss = s < 10 ? "0"+s: s+"";
                chrono.setText(hh+":"+mm+":"+ss);

                if (data.isRunning()){
                    chrono.setText(hh+":"+mm+":"+ss);
                } else {
                    if (isPair) {
                        isPair = false;
                        chrono.setText(hh+":"+mm+":"+ss);
                    }else{
                        isPair = true;
                        chrono.setText("");
                    }
                }

            }
        });
    }



    private void setfragement() {
        mContext = getApplicationContext();
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_dashboard_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_star_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_volume_up_black_48)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.community)));
        mTabLayout.addTab(mTabLayout.newTab().setCustomView(createTabView(R.drawable.round_contact_support_black_48)));
//
        mViewPager = (ViewPager) findViewById(R.id.pager_content);
        mContentsPagerAdapter = new ContentsPagerAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mContentsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

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

