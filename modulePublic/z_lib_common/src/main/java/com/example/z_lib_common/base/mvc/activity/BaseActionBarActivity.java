package com.example.z_lib_common.base.mvc.activity;

import android.graphics.Color;
import android.support.annotation.Keep;
import android.view.View;

import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_net.http.base.ICallBack;
import com.example.z_lib_common.widget.MyActionBar;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


/**
 * BaseActionBarActivity继承于BaseActivity，封装了actionBar的逻辑；
 * 继承于ActionBarBaseActivity的Activity都将默认带有ActionBar，并且只能使用AppTheme主题；
 * 只有那些ActionBar只带有Title和返回按钮的Activity方可继承
 *
 * @author puyantao
 * @description
 * @date 2019/9/27 17:40
 */
@Keep
public abstract class BaseActionBarActivity extends BaseActivity implements ICallBack {

    @Override
    protected void beforeInit() {
        super.beforeInit();
        //标题栏设置
        flActionBar.setVisibility(View.VISIBLE);
        MyActionBar actionBar = new MyActionBar(this);
        actionBar.setTitle(setTitle());
        actionBar.setActionBarColor(setActionBarColor());
        flActionBar.addView(actionBar);
    }

    /**
     * 设置actionBar的背景颜色
     *
     * @return
     */
    public int setActionBarColor() {
        return Color.parseColor("#03A9F4");
    }


    /**
     * 设置默认标题
     *
     * @return 标题
     */
    protected abstract String setTitle();

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
