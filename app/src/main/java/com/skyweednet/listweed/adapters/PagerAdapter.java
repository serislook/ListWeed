package com.skyweednet.listweed.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.skyweednet.listweed.R;
import com.skyweednet.listweed.views.FavoriteFragment;
import com.skyweednet.listweed.views.SamplesFragment;

/**
 * Created by osx on 20-10-17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private Context context;


    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SamplesFragment.newInstance();
            case 1:
                return FavoriteFragment.newInstance();

            default:
                return SamplesFragment.newInstance();
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
                return context.getString(R.string.Samples);
            case 1:
                return context.getString(R.string.Favorite);
            default:
                return context.getString(R.string.Samples);

        }

    }

}

