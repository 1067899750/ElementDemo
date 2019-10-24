package com.example.z_lib_girl.main;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.modulebase.arouter.ARouterUtils;
import com.example.z_lib_common.base.mvc.activity.BaseActionBarActivity;
import com.example.z_lib_girl.R;
import com.google.gson.JsonObject;

/**
 * @author puyantao
 * @description GirlsActivity
 * @email 1067899750@qq.com
 * @date 2019/9/25 20:37
 */
@Route(path = ARouterUtils.GIRLS_LIST)
public class GirlsActivity extends BaseActionBarActivity {

    private GirlsView mView;
    private GirlsContract.Presenter mPresenter;

    public static void startGirlsActivity(Context context) {
        Intent intent = new Intent(context, GirlsActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected String setTitle() {
        return getResources().getString(R.string.girl_activity_title);
    }

    @Override
    protected View setConnectView() {
        mView = new GirlsView(this);
        return mView;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {

    }

    @Override
    protected void initViews() {
        mPresenter = new GirlsPresenter(mView);
        mPresenter.start();
        parseManifests();
    }

    @Override
    public int setActionBarColor() {
        return getResources().getColor(R.color.colorPrimary);
    }

    private void parseManifests() {
        String packageName = getApplicationContext().getPackageName();
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                String appid = appInfo.metaData.getString("PUSH_APPID");
                String appsecret = appInfo.metaData.getString("PUSH_APPSECRET");
                String appkey = appInfo.metaData.getString("PUSH_APPKEY");

                Log.d("---> PUSH_APPID ", appid + "");
                Log.d("---> PUSH_APPSECRET ", appsecret + "");
                Log.d("---> PUSH_APPKEY ", appkey + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onError(int code, String message) {

    }
}
