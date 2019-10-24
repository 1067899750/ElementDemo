package com.example.z_lib_common.base;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.Keep;
import android.support.annotation.LayoutRes;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.example.z_lib_common.R;
import com.example.z_lib_common.http.base.ICallBack;
import com.example.z_lib_common.utils.Utils;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.gyf.barlibrary.ImmersionBar;


/**
 * @author puyantao
 * @description Activity基类
 * @date 2019/9/25 16:25
 */
@Keep
public abstract class BaseActivity extends AppCompatActivity{
    protected View vStatusBar;
    protected FrameLayout flRoot;
    protected ImmersionBar mImmersionBar;
    protected FrameLayout flActionBar;

    /**
     * 封装的findViewByID方法
     */
    @SuppressWarnings("unchecked")
    protected <T extends View> T $(@IdRes int id) {
        return (T) super.findViewById(id);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_base);
        vStatusBar = findViewById(R.id.v_status_bar);
        flRoot = findViewById(R.id.fl_root);
        flActionBar = findViewById(R.id.fl_action_bar);
        if (setLayoutId() != 0) {
            //用XML试图形式设置内容
            View content = getLayoutInflater().inflate(setLayoutId(), flRoot);

        } else if (setConnectView() != null) {
            //用试图形式设置内容
            flRoot.addView(setConnectView());

        }

        beforeInit();
        initViews();
        initDate();
        if (isImmersionBarEnable()) {
            initImmersionBar();
        }
        initActionBar();
        afterInit();


        ViewManager.getInstance().addActivity(this);
    }


    /**
     * 用XML文件设置，页面布局,
     *
     * @return
     */
    protected @LayoutRes
    int setLayoutId() {
        return 0;
    }

    /**
     * 设置内容, 直接用View试图代替
     *
     * @return
     */
    protected View setConnectView() {
        return null;
    }


    /**
     * 配置Activity初始化环境
     */
    protected void beforeInit() {
    }

    /**
     * 初始化试图
     */
    protected abstract void initViews();


    /**
     * 初始化数据
     */
    protected abstract void initDate();

    /**
     * 初始化顶部条
     */
    protected void initActionBar() {

    }

    /**
     * 是否使用沉浸式
     */
    protected boolean isImmersionBarEnable() {
        return true;
    }

    /**
     * 初始化沉浸式配置
     */
    protected void initImmersionBar() {
        //在BaseActivity里初始化
        mImmersionBar = ImmersionBar.with(this);
        View statusBarView = null;
        int viewId = getStatusBarViewId();
        if (viewId != -1) {
            statusBarView = findViewById(viewId);
        }
        if (statusBarView == null) {
            statusBarView = vStatusBar;
        }
        mImmersionBar.statusBarView(statusBarView)
                .statusBarDarkFont(true, 1f)
                .keyboardEnable(getKeyboardEnable())
                .init();
    }

    /**
     * 设置状态栏view的id
     */
    public @IdRes
    int getStatusBarViewId() {
        return -1;
    }


    protected void afterInit() {
    }

    public boolean getKeyboardEnable() {
        return true;
    }


    /**
     * 设置状态栏背景
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setStatusBar(Drawable drawable) {
        if (vStatusBar != null) {
            vStatusBar.setBackground(drawable);
        }
    }

    /**
     * 设置状态栏背景
     */
    public void setStatusBar(@DrawableRes int resId) {
        if (vStatusBar != null) {
            vStatusBar.setBackgroundResource(resId);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewManager.getInstance().finishActivity(this);
        if (mImmersionBar != null) {
            mImmersionBar.destroy();
            mImmersionBar = null;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    /******************************************管理 fragment *************************************/


    /**
     * 添加fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void addFragment(BaseFragment fragment, @IdRes int frameId) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .add(frameId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();

    }


    /**
     * 替换fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void replaceFragment(BaseFragment fragment, @IdRes int frameId) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .replace(frameId, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(fragment.getClass().getSimpleName())
                .commitAllowingStateLoss();

    }


    /**
     * 隐藏fragment
     *
     * @param fragment
     */
    protected void hideFragment(BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .hide(fragment)
                .commitAllowingStateLoss();

    }


    /**
     * 显示fragment
     *
     * @param fragment
     */
    protected void showFragment(BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .show(fragment)
                .commitAllowingStateLoss();

    }


    /**
     * 移除fragment
     *
     * @param fragment
     */
    protected void removeFragment(BaseFragment fragment) {
        Utils.checkNotNull(fragment);
        getSupportFragmentManager().beginTransaction()
                .remove(fragment)
                .commitAllowingStateLoss();

    }


    /**
     * 弹出栈顶部的Fragment
     */
    protected void popFragment() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }


}
