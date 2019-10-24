package com.example.z_lib_common.base;

import android.app.Application;

import com.example.z_lib_image.imageloader.loader.ImageLoader;
import com.example.z_lib_common.utils.Utils;

import java.util.List;

/**
 * Description 要想使用BaseApplication，必须在组件中实现自己的Application，并且继承BaseApplication；
 * 组件中实现的Application必须在debug包中的AndroidManifest.xml中注册，否则无法使用；
 * 组件的Application需置于java/debug文件夹中，不得放于主代码；
 * 组件中获取Context的方法必须为:BaseUtils.getContext()，不允许其他写
 *
 * @author puyantao
 * @description
 * @date 2019/10/14 9:31
 */
public class BaseApplication extends Application {

    public static final String ROOT_PACKAGE = "com.example";

    private static BaseApplication sInstance;

    private List<IApplicationDelegate> mAppDelegateList;
    public static String MY_STR = "";

    public static BaseApplication getIns() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Utils.init(this);
        ImageLoader.init(getApplicationContext());
        mAppDelegateList = ClassUtils.getObjectsWithInterface(this, IApplicationDelegate.class, ROOT_PACKAGE);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onCreate();
        }

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTerminate();
        }
    }


/**
 * OnLowMemory被回调时，已经没有后台进程；而onTrimMemory被回调时，还有后台进程。
 *
 * OnLowMemory是在最后一个后台进程被杀时调用，一般情况是low memory killer 杀进程后触发；而OnTrimMemory的触发更频繁，每次计算进程优先级时，只要满足条件，都会触发。
 *
 * 通过一键清理后，OnLowMemory不会被触发，而OnTrimMemory会被触发一次。
 */

    /**
     * 系统内存不足
     */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        ImageLoader.clearAllMemoryCaches();
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onLowMemory();
        }
    }

    /**
     * Android 4.0之后提供的API，系统会根据不同的内存状态来回调
     *
     * @param level
     */
    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoader.trimMemory(level);
        for (IApplicationDelegate delegate : mAppDelegateList) {
            delegate.onTrimMemory(level);
        }
    }
}























