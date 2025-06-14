package com.example.z_lib_net.http.net.retrofit.interceptor;

import com.example.z_lib_net.utils.AppPageUtil;
import com.example.z_lib_net.utils.NetUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Describe
 * @Author puyantao
 * @Email 1067899750@qq.com
 * @create 2019/6/4 15:55
 */
public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        final String versionCode = String.valueOf(AppPageUtil.getAppVersionCode(NetUtils.getContext()));
        final String appVersion = String.valueOf(AppPageUtil.getAppVersionName(NetUtils.getContext()));
        final String mobileType = AppPageUtil.getClientModel();
        final String mobileSystem = AppPageUtil.getOSVersionCode();

        String token = "";
        Request originalRequest = chain.request();
        Request.Builder requestBuilder = originalRequest.newBuilder()
//                .addHeader("Accept-Encoding", "gzip")
                .addHeader("Content-Type", "application/json; charset=utf-8")
                //前端对返回数据进行解压，要去这个属性
                .addHeader("Accept-Encoding", "gzip, deflate")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Cookie", "add cookies here")
//                .addHeader("Channel", channel)
                .addHeader("Mobile-type", mobileType)
                .addHeader("VersionCode", versionCode)
                .addHeader("Mobile-System", mobileSystem)
                .addHeader("x-requested-with", token)
                .addHeader("AppVersion", appVersion)
//                .addHeader("User-Agent", "Android," + mobileType + mobileSystem + "," + channel)
                .method(originalRequest.method(), originalRequest.body());
//        requestBuilder.addHeader("Authorization", "Bearer " + BaseConstant.TOKEN);//添加请求头信息，服务器进行token有效性验证
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}





