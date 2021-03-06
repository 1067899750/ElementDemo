package com.example.z_lib_net.http.net.retrofit.interceptor;

import android.content.Context;
import android.util.Log;

import com.example.z_lib_net.utils.NetUtils;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @describe 写入ssionId
 * @euthor puyantao
 * @email 1067899750@qq.com
 * @create 2019/8/8 14:18
 */
public class AddSsionInterceptor implements Interceptor {
    public static final String TAG = "---> Http";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HashSet<String> preferences = (HashSet) NetUtils.getContext().getSharedPreferences("config",
                Context.MODE_PRIVATE).getStringSet("cookie", null);
        if (preferences != null) {
            for (String cookie : preferences) {
                builder.addHeader("Cookie", cookie);
                // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
                Log.d(TAG, "Adding Header: " + cookie);
            }
        }
        return chain.proceed(builder.build());
    }
}















