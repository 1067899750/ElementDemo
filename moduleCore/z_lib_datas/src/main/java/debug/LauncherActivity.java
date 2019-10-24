package debug;

import android.widget.Toast;

import com.example.z_lib_common.base.mvc.activity.BaseActionBarActivity;
import com.example.z_lib_net.http.HttpHelper;
import com.example.z_lib_net.http.Url;
import com.example.z_lib_net.http.net.retrofit.dns.HttpDns;
import com.example.z_lib_datas.DataMainFragment;
import com.example.z_lib_datas.R;
import com.google.gson.JsonObject;

import java.util.HashMap;


/**
 * @author puyantao
 * @description 组件开发模式下，用于传递数据的启动Activity，集成模式下无效
 * @date 2019/9/25 14:47
 */
public class LauncherActivity extends BaseActionBarActivity {
    private String password = "e10adc3949ba59abbe56e057f20f883e";
    private String mobile = "18503970627";
    private String cid = "09164b5a280eda07839aabbd9e3c5961";

    @Override
    protected int setLayoutId() {
        return R.layout.data_layout;
    }

    @Override
    protected void initViews() {
        HashMap<String, String> loginMap = new HashMap<>();
        loginMap.put("password", password);
        loginMap.put("mobile", mobile);
        loginMap.put("cid", cid);
        loginMap.put("loginType", "1");
        HttpHelper.getInstance().get(HttpDns.baseUrl + Url.GET_LOGIN1, loginMap, this);
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected String setTitle() {
        return getResources().getString(R.string.data_name);
    }

    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {
        if (tag.equals("login")) {
            System.out.println("--->" + Thread.currentThread());
            Toast.makeText(this, jsonObject.toString(), Toast.LENGTH_SHORT).show();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.data_content_fl, DataMainFragment.newInstance())
                    .commit();
        }
    }


    @Override
    public void onFailed(String message) {
        System.out.println("--->" + Thread.currentThread());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(int code, String message) {
        System.out.println("--->" + Thread.currentThread());
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}





















