package com.example.z_lib_common.base.activity;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.view.View;

import com.example.z_lib_common.R;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.widget.MyActionBar;


/**
 * BaseActionBarActivity继承于BaseActivity，封装了actionBar的逻辑；
 * 继承于ActionBarBaseActivity的Activity都将默认带有ActionBar，并且只能使用AppTheme主题；
 * 只有那些ActionBar只带有Title和返回按钮的Activity方可继承
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 17:31
 */
@Keep
public abstract class BaseActionBarActivity extends BaseActivity {

    @Override
    protected void beforeInit() {
        super.beforeInit();
        //设置内容
        flRoot.addView(setConnectView());
        //标题栏设置
        flActionBar.setVisibility(View.VISIBLE);
        MyActionBar actionBar = new MyActionBar(this);
        actionBar.setTitle(setTitle());
        flActionBar.addView(actionBar);
    }

    /**
     * 设置默认标题
     *
     * @return 标题
     */
    protected abstract String setTitle();

    /**
     * 设置内容
     * @return
     */
    protected abstract View setConnectView();


}
