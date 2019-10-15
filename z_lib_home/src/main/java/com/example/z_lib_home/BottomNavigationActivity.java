package com.example.z_lib_home;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_common.base.ClassUtils;
import com.example.z_lib_common.base.IViewDelegate;
import com.example.z_lib_common.widget.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/27 15:04
 */
public class BottomNavigationActivity extends BaseActivity {

    private NoScrollViewPager mPager;
    private List<Fragment> mFragments;
    private FragmentAdapter mAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int i = item.getItemId();
            if (i == R.id.navigation_home) {
                mPager.setCurrentItem(0);
                return true;
            } else if (i == R.id.navigation_dashboard) {
                mPager.setCurrentItem(1);
                return true;
            } else if (i == R.id.navigation_notifications) {
                mPager.setCurrentItem(2);
                return true;
            }
            return false;
        }

    };


    @Override
    protected int setLayoutId() {
        return R.layout.home_activity_bottom_navigation;
    }

    @Override
    protected void initDate() {

    }


    @Override
    protected void initViews() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initViewPager();
    }

    private void initViewPager() {
        mFragments = new ArrayList<>();
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.HOME_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.NEWS_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.DATA_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.GIRLS_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.USER_MAIN_FRAGMENT).navigation());

        mPager = findViewById(R.id.container_pager);
        mAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragments);
        mPager.setPagerEnabled(false);
        mPager.setAdapter(mAdapter);
    }


    /**
     * 在News模块中寻找实现的Fragment
     *
     * @return Fragment
     */
    private BaseFragment getNewsFragment() {
        BaseFragment newsFragment = null;
        List<IViewDelegate> viewDelegates = ClassUtils.getObjectsWithInterface(this, IViewDelegate.class, "com.example.z_lib_news");
        if (viewDelegates != null && !viewDelegates.isEmpty()) {
            newsFragment = viewDelegates.get(0).getFragment("");
        }
        return newsFragment;
    }


}








