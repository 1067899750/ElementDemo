package com.example.z_lib_girl.data.source;


import com.example.z_lib_common.http.HttpHelper;
import com.example.z_lib_common.http.base.ICallBack;
import com.example.z_lib_girl.Constants;
import com.example.z_lib_girl.data.GirlsDataSource;
import com.example.z_lib_girl.data.bean.GirlsParser;
import com.google.gson.Gson;

import java.util.HashMap;
/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/14 9:40
 */
public class RemoteGirlsDataSource implements GirlsDataSource, ICallBack {
    private LoadGirlsCallback mLoadGirlsCallback;
    @Override
    public void getGirls(int size, int page, final LoadGirlsCallback callback) {
        mLoadGirlsCallback = callback;
        HashMap<String, String> loginMap = new HashMap<>();
        HttpHelper.getInstance().get(Constants.GAN_HUO_API + "福利/" + size + "/" + page, loginMap, this);
    }

    @Override
    public void onSuccess(String tag, String message) {
        Gson gson = new Gson();
        GirlsParser girlsParser = gson.fromJson(message, GirlsParser.class);
        mLoadGirlsCallback.onGirlsLoaded(girlsParser);
    }

    @Override
    public void onFailed(String message) {
        mLoadGirlsCallback.onDataNotAvailable();
    }

    @Override
    public void onError(int code, String message) {
        mLoadGirlsCallback.onDataNotAvailable();
    }
}
