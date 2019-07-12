package com.example.z_lib_girl;

import android.support.annotation.Keep;

import com.example.z_lib_common.base.IApplicationDelegate;
import com.example.z_lib_common.base.ViewManager;


/**
 * <p>类说明</p>
 */
@Keep
public class MyDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        //主动添加
        ViewManager.getInstance().addFragment(0, GirlsFragment.newInstance());
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
