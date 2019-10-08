package com.example.z_lib_news.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.mvc.activity.BaseSupportBarActivity;
import com.example.z_lib_news.R;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * <p>类说明</p>
 */
@Route(path = ARouterUtils.NEWS_CENTER)
public class NewsCenterActivity extends BaseSupportBarActivity {

    protected Toolbar mToolBar;
    protected TabLayout mTabLayout;
    protected ViewPager mViewPager;
    private NewsListViewAdapter mListAdapter;


    @Override
    protected int setLayoutId() {
        return R.layout.news_activity_news;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initViews() {
        mToolBar = findViewById(R.id.news_title_bar);
        setupToolBar(mToolBar, "知乎日报", false);

        mTabLayout =  findViewById(R.id.date_tab);
        mViewPager =  findViewById(R.id.message_pager);
        mListAdapter = new NewsListViewAdapter(getMessageListViews(), getWeekDate());
        mViewPager.setAdapter(mListAdapter);
        //setupWithViewPager必须在ViewPager.setAdapter()之后调用
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 获取ViewPager的viewList
     */
    private List<NewsListView> getMessageListViews() {
        List<NewsListView> viewList = new ArrayList<>();
        List<String> weekDate = getWeekDate();
        if (weekDate != null) {
            for (String tab : weekDate) {
                viewList.add(new NewsListView(this, tab));
            }
        }
        return viewList;
    }


    /**
     * 获取过去7天的时期，格式为yymmdd
     **/
    public static List<String> getWeekDate() {
        List<String> dates = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        for (int i = 0; i < 7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, 1 - i);
            dates.add(simpleDateFormat.format(calendar.getTime()));
        }
        return dates;
    }


}
