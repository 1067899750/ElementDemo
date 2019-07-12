package com.example.z_lib_main.debug;


import android.content.Context;
import android.support.multidex.MultiDex;

import com.example.z_lib_common.base.BaseApplication;

/**
 * <p>类说明</p>
 */
public class MainApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        login();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
    }


    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {
//        HttpClient client = new HttpClient.Builder()
//                .baseUrl("http://gank.io/api/data/")
//                .url("福利/10/1")
//                .build();
//        client.get(new OnResultListener<String>() {
//
//            @Override
//            public void onSuccess(String result) {
//                Logger.e(result);
//            }
//
//            @Override
//            public void onError(int code, String message) {
//                Logger.e(message);
//            }
//
//            @Override
//            public void onFailure(String message) {
//                Logger.e(message);
//            }
//        });
    }
}
