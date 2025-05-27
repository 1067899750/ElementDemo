package com.example.z_lib_news.main;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_base.arouter.ARouterUtils;
import com.example.z_lib_common.base.mvc.activity.BaseSupportBarActivity;
import com.example.z_lib_news.R;
import com.example.z_lib_news.fragment.attention.AttentionFragment;
import com.example.z_lib_news.fragment.home.HomeFragment;
import com.example.z_lib_news.fragment.me.MeFragment;
import com.example.z_lib_news.fragment.table.TableFragment;
import com.google.gson.JsonObject;

import java.util.ArrayList;

/**
 * @author puyantao
 * @description
 * @date 2019/10/14 9:56
 */
@Route(path = ARouterUtils.NEWS_CENTER)
public class NewsCenterActivity extends BaseSupportBarActivity {

    private static final String HOME = "home fragment";
    private static final String TABLE = "table fragment";
    private static final String ATTENTION = "attention fragment";
    private static final String ME = "me fragment";

    private RadioGroup mRadioGroup;
    private ArrayList<String> mFragments;
    /**
     * 记录选着的位置
     */
    private int mPosition = 0;

    private RadioButton radioTabHomePage;
    private RadioButton radioTabTable;
    private RadioButton radioTabAttention;
    private RadioButton radioTabMe;


    @Override
    protected void beforeInit() {
        super.beforeInit();
        mFragments = new ArrayList<>();
    }


    @Override
    protected int setLayoutId() {
        return R.layout.news_activity_news;
    }


    @Override
    protected void initViews() {
        mRadioGroup = findViewById(R.id.group_bottom_navigation_bar);
        radioTabHomePage = findViewById(R.id.radio_tab_home_page);
        radioTabTable = findViewById(R.id.radio_tab_table);
        radioTabAttention = findViewById(R.id.radio_tab_attention);
        radioTabMe = findViewById(R.id.radio_tab_me);
    }


    @Override
    protected void initDate() {
        mFragments.add(HOME);
        mFragments.add(TABLE);
        mFragments.add(ATTENTION);
        mFragments.add(ME);

        switchTab(getFragment(mPosition));

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radio_tab_home_page) {
                    mPosition = 0;
                } else if (checkedId == R.id.radio_tab_table) {
                    mPosition = 1;
                } else if (checkedId == R.id.radio_tab_attention) {
                    mPosition = 2;
                } else if (checkedId == R.id.radio_tab_me) {
                    mPosition = 3;
                }
                switchTab(getFragment(mPosition));

            }
        });

    }

    /**
     * 更新 RadioButton 的状态
     *
     * @param tab
     */
    private void switchTab(String tab) {
        if (tab.equals(HOME)) {
            radioTabHomePage.setChecked(true);

        } else if (tab.equals(TABLE)) {
            radioTabTable.setChecked(true);

        } else if (tab.equals(ATTENTION)) {
            radioTabAttention.setChecked(true);

        } else if (tab.equals(ME)) {
            radioTabMe.setChecked(true);
        }
        updateFragment();
    }

    /**
     * 更新 Fragment
     */
    public void updateFragment() {
        String baseFragment = getFragment(mPosition);
        switchFragment(baseFragment);
    }

    /**
     * 根据位置得到对应的 Fragment
     *
     * @param position
     * @return
     */
    private String getFragment(int position) {
        if (mFragments != null && mFragments.size() > 0) {
            String fragment = mFragments.get(position);
            return fragment;
        }
        return null;
    }


    /**
     * 切换Fragment
     *
     * @param fragmentId 上一个fragment
     */
    private void switchFragment(String fragmentId) {
        FragmentManager mFragmentManager = getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentManager.getBackStackEntryCount();
        for (int i = 0; i < mFragments.size(); i++) {
            String tag = String.valueOf(mFragments.get(i));
            Fragment fragment = mFragmentManager.findFragmentByTag(tag);
            if (mFragments.get(i) == fragmentId) {
                if (fragment == null || !fragment.isAdded()) {
                    fragment = createNewInstance(fragmentId);
                    mFragmentTransaction.add(R.id.layout_main_fragment_content, fragment, tag);
                } else {
                    mFragmentTransaction.show(fragment);
                }
            } else if (fragment != null) {
                mFragmentTransaction.hide(fragment);
            }
        }
        mFragmentTransaction.commitAllowingStateLoss();
    }


    /**
     * 返回处发的 fragment
     *
     * @param fragmentId
     * @return
     */
    private Fragment createNewInstance(String fragmentId) {
        if (fragmentId.equals(HOME)) {
            return HomeFragment.newInstance();
        } else if (fragmentId.equals(TABLE)) {
            return TableFragment.newInstance();
        } else if (fragmentId.equals(ATTENTION)) {
            return AttentionFragment.newInstance();
        } else if (fragmentId.equals(ME)) {
            return MeFragment.newInstance();
        } else {
            return new Fragment();
        }
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











