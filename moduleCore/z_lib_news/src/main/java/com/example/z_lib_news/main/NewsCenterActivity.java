package com.example.z_lib_news.main;

import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_base.arouter.ARouterUtils;
import com.example.z_lib_common.base.mvc.activity.BaseSupportBarActivity;
import com.example.z_lib_news.R;
import com.example.z_lib_news.fragment.table.FragmentTable;
import com.google.gson.JsonObject;

/**
 * @author puyantao
 * @description
 * @date 2019/10/14 9:56
 */
@Route(path = ARouterUtils.NEWS_CENTER)
public class NewsCenterActivity extends BaseSupportBarActivity {

    private static final int HOME = 0;
    private static final int TABLE = 1;
    private static final int ATTENTION = 2;
    private static final int ME = 3;

    private RadioGroup mRadioGroup;
    private int mCurrentTab;
//    private FragmentHome mFragmentHome;
    private FragmentTable mFragmentTable;
//    private FragmentAttention mFragmentAttention;
//    private FragmentMe mFragmentMe;


    @Override
    protected int setLayoutId() {
        return R.layout.news_activity_news;
    }


    @Override
    protected void initViews() {
        mRadioGroup = findViewById(R.id.group_bottom_navigation_bar);
    }


    @Override
    protected void initDate() {
        mCurrentTab = -1;
        mFragmentTable = FragmentTable.instance();
        switchTab(HOME);

        initEvent();

    }


    private void initEvent() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_tab_home_page){
                    switchTab(HOME);
                } else if (checkedId == R.id.radio_tab_table){
//                    switchTab(TABLE);
                }else if (checkedId == R.id.radio_tab_attention){
//                    switchTab(ATTENTION);
                }else if (checkedId == R.id.radio_tab_me){
//                    switchTab(ME);
                }

            }
        });
    }

    private void switchTab(int tab) {
        if (mCurrentTab == tab) {
            return;
        }
        if (tab == HOME){
            mRadioGroup.check(R.id.radio_tab_home_page);
            if (mFragmentTable != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.layout_main_fragment_content, mFragmentTable).commit();
            }
        } else if (tab == TABLE){
            mRadioGroup.check(R.id.radio_tab_home_page);
            if (mFragmentTable != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.layout_main_fragment_content, mFragmentTable).commit();
            }
        }else if (tab == ATTENTION){
            mRadioGroup.check(R.id.radio_tab_home_page);
            if (mFragmentTable != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.layout_main_fragment_content, mFragmentTable).commit();
            }
        }else if (tab == ME){
            mRadioGroup.check(R.id.radio_tab_home_page);
            if (mFragmentTable != null) {
                getSupportFragmentManager().beginTransaction().add(R.id.layout_main_fragment_content, mFragmentTable).commit();
            }
        }
        mCurrentTab = tab;
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











