package com.example.z_lib_news.fragment.table;


import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.z_lib_common.base.mvc.fragment.BaseMvcFragment;
import com.example.z_lib_news.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/6 14:09
 */
public class TableFragment extends BaseMvcFragment {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitleList;
    private List<Fragment> mFragmentList;

    public TableFragment() {
    }

    public static TableFragment newInstance() {
        TableFragment fragment = new TableFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment_table;
    }

    @Override
    protected void initViews(View root) {
        mTabLayout = root.findViewById(R.id.tab_layout_title);
        mViewPager = root.findViewById(R.id.page_collapsing);

        mTitleList = new ArrayList<>();
        mFragmentList = new ArrayList<>();
    }

    @Override
    protected void initData() {

        mTitleList.add("推荐");
        mTitleList.add("抖音");
        mTitleList.add("音乐");
        mTitleList.add("搞笑");
        mTitleList.add("社会");
        mTitleList.add("影视");


        mFragmentList.add(TableChildFragment.newInstance(5, "推荐"));
        mFragmentList.add(TableChildFragment.newInstance(10, "抖音"));
        mFragmentList.add(TableChildFragment.newInstance(20, "音乐"));
        mFragmentList.add(TableChildFragment.newInstance(1, "搞笑"));
        mFragmentList.add(TableChildFragment.newInstance(24, "社会"));
        mFragmentList.add(TableChildFragment.newInstance(2, "影视"));
        mViewPager.setAdapter(new TabFragmentAdapter(getFragmentManager(), mFragmentList, mTitleList));
        mTabLayout.setupWithViewPager(mViewPager);
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



































