package com.skyweednet.listweed.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.skyweednet.listweed.main.MainActivity;
import com.skyweednet.listweed.views.FavoriteFragment;
import com.skyweednet.listweed.views.SamplesFragment;

/**
 * Created by osx on 20-10-17.
 */

public class PagerAdapter extends FragmentPagerAdapter {


    public PagerAdapter(android.support.v4.app.FragmentManager supportFragmentManager, MainActivity mainActivity) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SamplesFragment.newIstance();
            case 1:
                return FavoriteFragment.newIntance();

            default:
                return SamplesFragment.newIstance();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SAMPLES";
            case 1:
                return "FAVORITE SAMPLES";

        }
        return null;
    }

}

