package com.example.z_lib_base.utils;

import android.content.Context;

import com.example.z_lib_image.utils.ImageUtils;
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


    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        BaseUtils.context = context;
    }
}
