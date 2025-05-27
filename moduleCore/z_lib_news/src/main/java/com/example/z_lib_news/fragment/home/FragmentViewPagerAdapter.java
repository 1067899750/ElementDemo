package com.example.z_lib_news.fragment.home;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;
/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/5 17:31
 */
public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;

    public FragmentViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int arg0) {
        return fragmentList.get(arg0);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
