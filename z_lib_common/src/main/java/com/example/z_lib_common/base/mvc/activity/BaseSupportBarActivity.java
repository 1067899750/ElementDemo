package com.example.z_lib_common.base.mvc.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.z_lib_common.R;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.http.base.ICallBack;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author puyantao
 * @describe 用design 框架
 * @create 2019/9/27 16:06
 */
public abstract class BaseSupportBarActivity extends BaseActivity implements ICallBack {
    @Override
    protected void afterInit() {
        super.afterInit();
        flActionBar.setVisibility(View.GONE);
    }

    /**
     * Setup the toolbar.
     *
     * @param toolbar   toolbar
     * @param hideTitle 是否隐藏Title
     */
    protected void setupToolBar(Toolbar toolbar, String title, boolean hideTitle) {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(title);
            if (hideTitle) {
                //隐藏Title
                actionBar.setDisplayShowTitleEnabled(false);
            }
        }
    }

    /**
     * 返回 json 数据
     * @param tag
     * @param jsonObject
     */
    protected abstract void onSuccess(String tag, JsonObject jsonObject);


    @Override
    public void onSuccess(String tag, String message) {
        JsonObject jsonObject = new JsonParser().parse(message).getAsJsonObject();
        onSuccess(tag, jsonObject);
    }

}














