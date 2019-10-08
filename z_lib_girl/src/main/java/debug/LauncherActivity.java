package debug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.z_lib_girl.R;
import com.example.z_lib_girl.main.GirlsActivity;


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
        //在这里传值给需要调试的Activity
        setContentView(R.layout.girl_fragment);
        GirlsActivity.startGirlsActivity(this);
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.girl_content_cl, GirlsMainFragment.newInstance())
//                .commit();

    }

}





















