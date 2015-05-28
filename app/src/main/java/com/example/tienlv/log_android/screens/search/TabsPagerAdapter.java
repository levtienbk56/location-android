package com.example.tienlv.log_android.screens.search;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {


    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return SearchPresenter.diskFragment;
            case 1:
                return SearchPresenter.locationFragment;
            case 2:
                return SearchPresenter.albumFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
