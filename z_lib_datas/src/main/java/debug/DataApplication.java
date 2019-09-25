package debug;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.base.BaseApplication;

/**
 *
 * @description 数据
 * @author puyantao
 * @date 2019/9/25 14:45
 */
public class DataApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        login();
        ARouter.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
//        MultiDex.install(this);
    }


    /**
     * 在这里模拟登陆，然后拿到sessionId或者Token
     * 这样就能够在组件请求接口了
     */
    private void login() {

    }

}
