package com.example.z_lib_common.base.mvc.fragment;

import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_net.http.base.ICallBack;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author puyantao
 * @describe
 * @create 2019/10/14 10:07
 */
public abstract class BaseMvcFragment extends BaseFragment implements ICallBack {
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
