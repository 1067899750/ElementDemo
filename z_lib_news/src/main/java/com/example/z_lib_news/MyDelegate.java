package com.example.z_lib_news;

import android.support.annotation.Keep;

import com.example.z_lib_common.base.IApplicationDelegate;
import com.example.z_lib_common.base.ViewManager;
import com.orhanobut.logger.Logger;

/**
 * <p>类说明</p>
 */
@Keep
public class MyDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
//        Logger.init("pattern");
        //主动添加
        ViewManager.getInstance().addFragment(0, NewsFragment.newInstance());
    }

    @Override
    public void onTerminate() {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onTrimMemory(int level) {

    }
}
