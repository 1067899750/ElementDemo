package com.example.z_lib_common.base;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;

import com.example.z_lib_common.R;


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

    /*默认的ActionBar*/
    protected ActionBar mActionBar;

    /**
     * 设置默认标题id
     *
     * @return 标题id
     */
    @StringRes
    protected abstract int setTitleId();


    /**
     * 更新标题
     *
     * @param title String标题
     */
    protected void setTitle(String title) {
        if (mActionBar != null) {
            mActionBar.setTitle(title);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //标题栏设置
        mActionBar = getSupportActionBar();
        if (mActionBar != null) {
            mActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            mActionBar.setDisplayHomeAsUpEnabled(true);
            mActionBar.setHomeButtonEnabled(true);
            mActionBar.setTitle(setTitleId());
        }
    }

}