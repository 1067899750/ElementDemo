package com.example.z_lib_image.utils;

import android.content.Context;

/**
 * @author puyantao
 * @describe module入口
 * @create 2019/10/24 15:13
 */
public class ImageUtils {
    private static Context context;

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(Context context) {
        ImageUtils.context = context;
    }


    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ImageUtils.context = context;
    }
}
