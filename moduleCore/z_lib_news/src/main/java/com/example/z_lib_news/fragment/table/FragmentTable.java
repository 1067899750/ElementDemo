package com.example.z_lib_news.fragment.table;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;


import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_news.R;

import java.util.ArrayList;

import butterknife.BindView;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/5 16:35
 */
public class FragmentTable extends BaseFragment {
    private ViewPager mViewPager;
    private FragmentViewPagerAdapter mFragmentViewPagerAdapter;
    private ArrayList<Fragment> mFragments;
    private RadioButton tab_1;
    private RadioButton tab_2;
    private RadioButton tab_3;

    public static FragmentTable instance() {
        return new FragmentTable();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment_table;
    }

    @Override
    protected void initViews(View view) {
        mFragments = new ArrayList<>();
        mViewPager = view.findViewById(R.id.finance_viewpager);
        tab_1 = view.findViewById(R.id.tab_1);
        tab_2 = view.findViewById(R.id.tab_2);
        tab_3 = view.findViewById(R.id.tab_3);
    }


    @Override
    protected void initData() {
        for (int i =0; i < 3; i ++){
            mFragments.add(TableChildFragment.newInstance());
        }
        mFragmentViewPagerAdapter = new FragmentViewPagerAdapter(getChildFragmentManager(), mFragments);
        mViewPager.setAdapter(mFragmentViewPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (0 == i) {
                    tab_1.setChecked(true);
                } else if (1 == i) {
                    tab_2.setChecked(true);
                } else if (2 == i) {
                    tab_3.setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }



}














