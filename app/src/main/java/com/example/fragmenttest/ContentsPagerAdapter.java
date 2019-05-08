package com.example.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
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

            case 0:
                HowTo howTo = new HowTo();
                return howTo;

            case 1:
                Instrument_Panel instrument_Panel = new Instrument_Panel();
                return instrument_Panel;

            case 2:
                Horn horn = new Horn();
                return horn;

            case 3:
                Bluetooth bluetooth = new Bluetooth();
                return bluetooth;

            case 4:
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
