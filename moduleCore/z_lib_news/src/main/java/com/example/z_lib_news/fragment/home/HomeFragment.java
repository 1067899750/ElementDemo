package com.example.z_lib_news.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;


import com.example.z_lib_common.base.mvc.fragment.BaseMvcActionBarFragment;
import com.example.z_lib_news.R;
import com.example.z_lib_news.fragment.table.TableFragment;
import com.google.gson.JsonObject;

import java.util.ArrayList;



/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/5 16:35
 */
public class HomeFragment extends BaseMvcActionBarFragment {
    private ViewPager mViewPager;
    private FragmentViewPagerAdapter mFragmentViewPagerAdapter;
    private ArrayList<Fragment> mFragments;
    private RadioButton tab_1;
    private RadioButton tab_2;
    private RadioButton tab_3;
    private LinearLayout ll_show;

    public HomeFragment() {
    }

    public static TableFragment newInstance() {
        TableFragment fragment = new TableFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected String setTitle() {
        return "首页";
    }


    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment_home;
    }

    @Override
    protected void initViews(View view) {
        mFragments = new ArrayList<>();
        mViewPager = view.findViewById(R.id.finance_viewpager);
        tab_1 = view.findViewById(R.id.tab_1);
        tab_2 = view.findViewById(R.id.tab_2);
        tab_3 = view.findViewById(R.id.tab_3);
        ll_show = view.findViewById(R.id.ll_show);
        ll_show.setVisibility(View.VISIBLE);
    }


    @Override
    protected void initData() {
        for (int i =0; i < 3; i ++){
            mFragments.add(HomeChildFragment.newInstance());
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

        tab_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mViewPager.setCurrentItem(0);
                }
            }
        });
        tab_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mViewPager.setCurrentItem(1);
                }
            }
        });
        tab_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mViewPager.setCurrentItem(2);
                }
            }
        });

    }

    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onError(int code, String message) {

    }
}














