package com.example.z_lib_base.utils;

import android.content.Context;

import com.example.z_lib_image.utils.ImageUtils;
import com.example.z_lib_net.http.HttpHelper;
import com.example.z_lib_net.http.base.IHttpProcessor;
import com.example.z_lib_net.http.net.retrofit.dns.HttpDns;
import com.example.z_lib_net.utils.NetUtils;

/**
 * @author puyantao
 * @describe module入口
 * @create 2019/10/24 15:13
 */
public class BaseUtils {
    private static Context context;

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        BaseUtils.context = context;
        //初始化 image 模块
        ImageUtils.init(getContext());
        //初始化 Net 模块
        NetUtils.init(getContext());
    }


    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new NullPointerException("you should init first");
    }


    /**
     *  初始化网络
     * @param httpProcessor
     * @param baseUrl
     */
    public static void initHttp(IHttpProcessor httpProcessor, String baseUrl){
        //初始化网络 httpHelper
        HttpHelper.init(httpProcessor);
        //初始化域名
        HttpDns.getInstance().init(baseUrl);
    }


}


















