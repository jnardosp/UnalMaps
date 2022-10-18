package com.poo.unalmaps.ui.main;

import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.poo.unalmaps.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class ScreenPagerAdapter extends FragmentStateAdapter {
    public static int NUM_PAGES = 4;

    public ScreenPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @Override
    public Fragment createFragment(int pagePosition) {
        // getFragment is called to instantiate the fragment(Page) for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return new Fragment();
    }

    @Override
    public int getItemCount() {
        // Show total pages.
        return NUM_PAGES;
    }
}