package debug;


import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.base.BaseApplication;

import com.example.z_lib_news.Constants;
import com.example.z_lib_news.data.bean.StoryList;
import com.orhanobut.logger.Logger;

/**
 *
 * @description 类说明
 * @author puyantao
 * @date 2019/9/25 14:48
 */
public class NewsApplication extends BaseApplication {

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
        HttpClient client = new HttpClient.Builder()
                .baseUrl(Constants.ZHIHU_DAILY_BEFORE_MESSAGE)
                .url("20170419")
                .bodyType(DataType.JSON_OBJECT, StoryList.class)
                .build();
        client.get(new OnResultListener<StoryList>() {

            @Override
            public void onSuccess(StoryList result) {
                Logger.e(result.toString());
            }

            @Override
            public void onError(int code, String message) {
                Logger.e(message);
            }

            @Override
            public void onFailure(String message) {
                Logger.e(message);
            }
        });
    }

}
