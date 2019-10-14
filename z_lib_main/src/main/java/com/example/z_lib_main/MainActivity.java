package com.example.z_lib_main;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.bankres.BankResFactory;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.base.BaseApplication;
import com.example.z_lib_common.base.ViewManager;
import com.example.z_lib_common.http.HttpHelper;
import com.example.z_lib_common.http.Url;
import com.example.z_lib_common.http.base.ICallBack;
import com.example.z_lib_common.http.net.retrofit.dns.HttpDns;
import com.example.z_lib_common.utils.ToastUtils;
import com.example.z_lib_common.widget.NewStyleToolBar;
import com.example.z_lib_common.widget.annotation.PageTypeAnnotation;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * @author puyantao
 * @description 首页
 * @date 2019/9/25 14:16
 */
public class MainActivity extends BaseActivity implements ICallBack {
    private long mExitTime = 0;
    private NewStyleToolBar mNewStyleToolBar;
    private ArrayList<String> mFragments;

    /**
     * 缓存Fragment或上次显示的Fragment
     */
    private Fragment tempFragment;

    /**
     * 记录选着的位置
     */
    private int mPosition = 0;


    private String password = "e10adc3949ba59abbe56e057f20f883e";
    private String mobile = "18503970627";
    private String cid = "09164b5a280eda07839aabbd9e3c5961";


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
        mFragments.add(ARouterUtils.HOME_MAIN_FRAGMENT);
        mFragments.add(ARouterUtils.NEWS_MAIN_FRAGMENT);
        mFragments.add(ARouterUtils.DATA_MAIN_FRAGMENT);
        mFragments.add(ARouterUtils.GIRLS_MAIN_FRAGMENT);
        mFragments.add(ARouterUtils.USER_MAIN_FRAGMENT);
        updateFragment();
        Log.d("--->", BaseApplication.MY_STR);


        initLogin();

    }

    private void initLogin() {

        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("password", password);
        loginMap.put("mobile", mobile);
        loginMap.put("cid", cid);
        loginMap.put("loginType", "1");
        HttpHelper.getInstance().get(HttpDns.baseUrl + Url.GET_LOGIN1, loginMap, this);
    }


    @Override
    public void onSuccess(String tag, String message) {
        if (tag.equals("login")) {
            System.out.println("--->" + Thread.currentThread());
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onFailed(String message) {
        System.out.println("--->" + Thread.currentThread());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int code, String message) {
        System.out.println("--->" + Thread.currentThread());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
                    mFragmentTransaction.add(R.id.fl_main_content, fragment, tag);
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
        if (fragmentId.equals(ARouterUtils.HOME_MAIN_FRAGMENT)) {
            return (Fragment) ARouter.getInstance().build(ARouterUtils.HOME_MAIN_FRAGMENT).navigation();
        } else if (fragmentId.equals(ARouterUtils.NEWS_MAIN_FRAGMENT)) {
            return (Fragment) ARouter.getInstance().build(ARouterUtils.NEWS_MAIN_FRAGMENT).navigation();
        } else if (fragmentId.equals(ARouterUtils.DATA_MAIN_FRAGMENT)) {
            return (Fragment) ARouter.getInstance().build(ARouterUtils.DATA_MAIN_FRAGMENT).navigation();
        } else if (fragmentId.equals(ARouterUtils.GIRLS_MAIN_FRAGMENT)) {
            return (Fragment) ARouter.getInstance().build(ARouterUtils.GIRLS_MAIN_FRAGMENT).navigation();
        } else if (fragmentId.equals(ARouterUtils.USER_MAIN_FRAGMENT)) {
            return (Fragment) ARouter.getInstance().build(ARouterUtils.USER_MAIN_FRAGMENT).navigation();
        } else {
            return new Fragment();
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
















