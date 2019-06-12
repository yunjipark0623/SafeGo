package com.example.fragmenttest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fragmenttest.Fragment.Bluetooth;
import com.example.fragmenttest.Fragment.Horn;
import com.example.fragmenttest.Fragment.HowTo;
import com.example.fragmenttest.Fragment.Instrument_Panel;
import com.example.fragmenttest.Fragment.Profile;

public class ContentsPagerAdapter extends FragmentStatePagerAdapter{

    private int mPageCount;

    public ContentsPagerAdapter(FragmentManager fm, int pageCount) {
        super(fm);
        this.mPageCount = pageCount;
    }



    @Override

    public Fragment getItem(int position) {

        switch (position) {

//            대쉬보드
            case 0:
                Instrument_Panel instrument_Panel = new Instrument_Panel();
                return instrument_Panel;

//                작동법
            case 1:
                HowTo howTo = new HowTo();
                return howTo;

//            case 2:
//                Horn horn = new Horn();
//                return horn;

//            커뮤니티
            case 2:
                Bluetooth bluetooth = new Bluetooth();
                return bluetooth;


//                고객센터
            case 3:
                Profile profile = new Profile();
                return profile;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mPageCount;
    }
}
