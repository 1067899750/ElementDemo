package debug;


import com.example.z_lib_common.base.mvc.activity.BaseActionBarActivity;
import com.example.z_lib_news.NewsMainFragment;
import com.example.z_lib_news.R;
import com.google.gson.JsonObject;

/**
 * @author puyantao
 * @description 组件开发模式下，用于传递数据的启动Activity，集成模式下无效
 * @date 2019/9/25 14:47
 */
public class LauncherActivity extends BaseActionBarActivity {

    @Override
    protected int setLayoutId() {
        return R.layout.news_fragment;
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected void initDate() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.news_rl, NewsMainFragment.newInstance())
                .commit();
    }

    @Override
    protected String setTitle() {
        return null;
    }

    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onError(int code, String message) {

    }
}





















