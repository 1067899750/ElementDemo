package com.example.z_lib_news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.modulebase.arouter.ARouterUtils;
import com.example.z_lib_common.base.mvc.activity.BaseSupportBarActivity;
import com.example.z_lib_news.R;
import com.google.gson.JsonObject;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/14 9:56
 */
@Route(path = ARouterUtils.NEWS_CENTER)
public class NewsCenterActivity extends BaseSupportBarActivity {

    protected Toolbar mToolBar;
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;


    @Override
    protected int setLayoutId() {
        return R.layout.news_activity_news;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {

    }

    @Override
    protected void initViews() {
        mToolBar = findViewById(R.id.news_title_bar);
        setupToolBar(mToolBar, "知乎日报", false);

        mTabLayout =  findViewById(R.id.date_tab);
        mViewPager =  findViewById(R.id.message_pager);

    }



    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onError(int code, String message) {

    }
}
