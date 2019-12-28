package debug;


import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.base.BaseApplication;
import com.example.z_lib_net.http.net.retrofit.RetrofitProcessor;
import com.example.z_lib_common.utils.CommonUtils;

/**
 *
 * @description 类说明
 * @author puyantao
 * @date 2019/10/15 16:19
 */
public class GirlsApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ARouter.init(this);
        //初始化
        CommonUtils.initHttp(new RetrofitProcessor(this), "https://yanyangtian.purang.com/");
    }


}













