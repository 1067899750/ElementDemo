package debug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.z_lib_home.HomeMianFragment;
import com.example.z_lib_home.R;


/**
 * @author puyantao
 * @description 组件开发模式下，用于传递数据的启动Activity，集成模式下无效
 * @date 2019/9/25 14:47
 */
public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在这里传值给需要调试的Activity
        setContentView(R.layout.home_fragment);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.home_content_cl, HomeMianFragment.newInstance())
                .commit();

    }

}





















