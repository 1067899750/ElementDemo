package com.example.z_lib_common.base.mvc.fragment;

import android.graphics.Color;
import android.view.View;

import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_common.widget.MyActionBar;
import com.example.z_lib_net.http.base.ICallBack;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author puyantao
 * @describe
 * @create 2019/11/6 9:19
 */
public abstract class BaseMvcActionBarFragment extends BaseFragment  implements ICallBack {
    protected MyActionBar actionBar;

    @Override
    protected void beforeInit() {
        super.beforeInit();
        //标题栏设置
        flActionBar.setVisibility(View.VISIBLE);
        actionBar = new MyActionBar(getContext());
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



























