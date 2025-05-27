package com.example.z_lib_common.base;

import androidx.annotation.Keep;

/**
 *
 * Description 用于加载不同模块的Fragment
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 17:37
 */
@Keep
public interface IApplicationDelegate {

    void onCreate();

    void onTerminate();

    void onLowMemory();

    void onTrimMemory(int level);

}
