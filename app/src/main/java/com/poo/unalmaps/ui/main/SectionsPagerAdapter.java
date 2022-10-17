package com.poo.unalmaps.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.poo.unalmaps.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tabText2,
                                                      R.string.tab_text_3, R.string.tabText4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        if(position == 0) {
            InfoTabFrag infoTabFrag = new InfoTabFrag();
            return infoTabFrag;
        }
        else if(position == 1){
            LocateMeTabFrag locateMeTabFrag = new LocateMeTabFrag();
            return locateMeTabFrag;
        }
        else if(position == 2){
            GuideMeTabFrag guideMeTabFrag = new GuideMeTabFrag();
            return guideMeTabFrag;
        }
        else if(position == 3){
            ConfigTabFrag configTabFrag = new ConfigTabFrag();
            return configTabFrag;
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}