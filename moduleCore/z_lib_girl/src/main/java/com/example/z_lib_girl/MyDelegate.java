package com.example.z_lib_girl;

import android.support.annotation.Keep;

import com.example.z_lib_common.base.IApplicationDelegate;
import com.example.z_lib_common.base.ViewManager;
import com.example.z_lib_common.utils.CommonUtils;


/**
 * <p>类说明</p>
 */
@Keep
public class MyDelegate implements IApplicationDelegate {

    @Override
    public void onCreate() {
        CommonUtils.initLogger();
        //主动添加
        ViewManager.getInstance().addFragment(0, GirlsMainFragment.newInstance());
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
