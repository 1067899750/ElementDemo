package com.example.z_lib_news.fragment.table;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author puyantao
 * @describe
 * @create 2019/11/6 16:03
 */
public class TabFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;

    private List<String> mTitles;

    public TabFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        this(fm, fragments, null);
    }

    public TabFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> titles) {
        super(fm);
        mFragments = fragments;
        this.mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles == null || position > mTitles.size() - 1) {
            return null;
        }
        return mTitles.get(position);
    }
}










