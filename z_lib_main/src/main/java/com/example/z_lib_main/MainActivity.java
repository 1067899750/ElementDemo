package com.example.z_lib_main;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.arouter.ARouterManager;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.bankres.BankResFactory;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.base.BaseApplication;
import com.example.z_lib_common.base.ViewManager;
import com.example.z_lib_common.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Description
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 17:20
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private long mExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_main);
        ButterKnife.bind(this);

        findViewById(R.id.news_button).setOnClickListener(this);
        findViewById(R.id.girls_button).setOnClickListener(this);
        findViewById(R.id.fragment_button).setOnClickListener(this);

        Log.d("--->", BaseApplication.MY_STR);
        getAppliactionPackage();
        getChannel();
    }

    private void getAppliactionPackage() {
        String str = BankResFactory.getInstance().getPackage();
        Log.d("---> BankResFactory", str);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.news_button) {
            //跳转到NewsCenterActivity
            ARouterManager.startNewsCanterActivity();

        }else if (i == R.id.girls_button){
            //跳转到GirlsActivity
            ARouterManager.startGrilsListActivity();

        }else if (i == R.id.fragment_button){
            startActivity(new Intent(this, BottomNavigationActivity.class));

        }
    }


    private void getChannel() {
        try {
            PackageManager pm = getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
            String packageName = appInfo.packageName;
            Log.d("---> packageName ",packageName);
            String className = appInfo.className;
            String name = appInfo.name;


            Bundle bundle =  appInfo.metaData;

            String APP_ID = appInfo.metaData.getString("APP_ID");
            Log.d("---> APP_ID ",APP_ID + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            //两秒之内按返回键就会退出
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                ToastUtils.showShortToast(getString(R.string.main_app_exit_hint));
                mExitTime = System.currentTimeMillis();
            } else {
                ViewManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}


















