package com.example.z_lib_main;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.bankres.BankResFactory;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.base.BaseApplication;
import com.example.z_lib_common.base.ViewManager;
import com.example.z_lib_common.utils.ToastUtils;
import com.example.z_lib_common.widget.NewStyleToolBar;
import com.example.z_lib_common.widget.annotation.PageTypeAnnotation;

import java.util.ArrayList;


/**
 * @author puyantao
 * @description 首页
 * @date 2019/9/25 14:16
 */
public class MainActivity extends BaseActivity {
    private long mExitTime = 0;
    private NewStyleToolBar mNewStyleToolBar;
    private ArrayList<Fragment> mFragments;

    /**
     * 缓存Fragment或上次显示的Fragment
     */
    private Fragment tempFragment;

    /**
     * 记录选着的位置
     */
    private int mPosition = 0;

    @Override
    protected int setLayoutId() {
        return R.layout.main_activity_main;
    }

    @Override
    protected void beforeInit() {
        super.beforeInit();
        mFragments = new ArrayList<>();
    }

    @Override
    protected void afterInit() {
        super.afterInit();
        getApplicationPackage();
        getChannel();
    }


    @Override
    protected void initViews() {
        mNewStyleToolBar = findViewById(R.id.ns_tool_bar);
    }

    @Override
    protected void initDate() {
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.HOME_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.NEWS_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.DATA_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.GIRLS_MAIN_FRAGMENT).navigation());
        mFragments.add((Fragment) ARouter.getInstance().build(ARouterUtils.USER_MAIN_FRAGMENT).navigation());
        updateFragment();
        Log.d("--->", BaseApplication.MY_STR);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mNewStyleToolBar.setClickChildLocationListener(new NewStyleToolBar.OnClickChildLocationListener() {
            @Override
            public void onChildPosition(int position) {
                Log.d("---> position", position + "");
                mPosition = position;
                updateFragment();
            }
        });

    }

    /**
     * 重新设置 bg 选着的位置
     *
     * @param position
     */
    public void setNewGbPosition(@PageTypeAnnotation int position) {
        mPosition = position;
        updateFragment();
    }


    public void updateFragment() {
        mNewStyleToolBar.setRbPosition(mPosition);
        Fragment baseFragment = getFragment(mPosition);
        switchFragment(tempFragment, baseFragment, mPosition);
    }

    /**
     * 根据位置得到对应的 Fragment
     *
     * @param position
     * @return
     */
    private Fragment getFragment(int position) {
        if (mFragments != null && mFragments.size() > 0) {
            Fragment fragment = mFragments.get(position);
            return fragment;
        }
        return null;
    }

    /**
     * 切换Fragment
     *
     * @param fragment     上一个fragment
     * @param nextFragment 要替换的fragment
     */
    private void switchFragment(Fragment fragment, Fragment nextFragment, final int position) {
        Log.i("--> : ", position + "");
        if (tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                //判断nextFragment是否添加成功
                if (!nextFragment.isAdded()) {
                    //隐藏当前的Fragment
                    if (fragment != null) {
                        fragmentTransaction.hide(fragment);
                    }
                    //添加Fragment
                    fragmentTransaction.add(R.id.fl_main_content, nextFragment).commitAllowingStateLoss();
                } else {
                    //隐藏当前Fragment
                    if (fragment != null) {
                        fragmentTransaction.hide(fragment);
                    }
                    fragmentTransaction.show(nextFragment).commitAllowingStateLoss();
                }
            }
        }
    }


    private void getApplicationPackage() {
        String str = BankResFactory.getInstance().getPackage();
        Log.d("---> BankResFactory", str);
    }

    private void getChannel() {
        try {
            PackageManager pm = getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String packageName = appInfo.packageName;
            Log.d("---> packageName ", packageName);
            String className = appInfo.className;
            String name = appInfo.name;


            Bundle bundle = appInfo.metaData;

            String APP_ID = appInfo.metaData.getString("APP_ID");
            Log.d("---> APP_ID ", APP_ID + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(getString(R.string.main_app_exit_hint));
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


















