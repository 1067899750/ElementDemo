package com.example.z_lib_net.utils;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.StringRes;

/**
 * @author puyantao
 * @describe
 * @create 2019/10/24 15:30
 */
public class NetUtils {
    private static Context context;

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        NetUtils.context = context;
    }


    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        NetUtils.context = context;
    }


    /**
     * 全局获取String的方法
     *
     * @param id 资源Id
     * @return String
     */
    public static String getString(@StringRes int id) {
        return context.getResources().getString(id);
    }



}












