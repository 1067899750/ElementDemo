package com.example.elementdemo;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.multidex.MultiDex;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.z_lib_common.bankres.ConfigPermission;
import com.example.z_lib_common.base.BaseApplication;
import com.example.z_lib_net.http.net.retrofit.RetrofitProcessor;
import com.example.z_lib_common.multipackage.EnvType;
import com.example.z_lib_common.utils.CommonUtils;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.acra.collector.CrashReportData;
import org.acra.sender.EmailIntentSender;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;


/**
 *
 * @description 这里仅需做一些初始化的工作
 * @author puyantao
 * @date 2019/10/15 15:52
 */
@ReportsCrashes(
        mailTo = "1067899750@qq.com",
        mode = ReportingInteractionMode.DIALOG,
        customReportContent = {
                ReportField.APP_VERSION_NAME,
                ReportField.ANDROID_VERSION,
                ReportField.PHONE_MODEL,
                ReportField.CUSTOM_DATA,
                ReportField.BRAND,
                ReportField.STACK_TRACE,
                ReportField.LOGCAT,
                ReportField.USER_COMMENT},
        resToastText = R.string.crash_toast_text,
        resDialogText = R.string.crash_dialog_text,
        resDialogTitle = R.string.crash_dialog_title)
public class MyApplication extends BaseApplication {
    /**
     * 多环境打包标志  1：开发环境 2：测试环境3：生产环境
     */
    public static int envType = BuildConfig.ENV_TYPE;

    @Override
    public void onCreate() {
        super.onCreate();
        if (CommonUtils.isAppDebug()) {
            //开启InstantRun之后，一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
        //崩溃日志记录初始化
        ACRA.init(this);
        ACRA.getErrorReporter().removeAllReportSenders();
        ACRA.getErrorReporter().setReportSender(new CrashReportSender());

        //初始化
        CommonUtils.initHttp( new RetrofitProcessor(this), getResources().getString(R.string.base_url));

        //初始化多环境打包
        initMultiPackage();

        getOtherMessage();
        getChannel();
        parseManifests();

        int envType = BuildConfig.ENV_TYPE;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
    }

    /**
     * 发送崩溃日志
     */
    private class CrashReportSender implements ReportSender {
        CrashReportSender() {
            ACRA.getErrorReporter().putCustomData("PLATFORM", "ANDROID");
            ACRA.getErrorReporter().putCustomData("BUILD_ID", android.os.Build.ID);
            ACRA.getErrorReporter().putCustomData("DEVICE_NAME", android.os.Build.PRODUCT);
        }

        @Override
        public void send(Context context, CrashReportData crashReportData) throws ReportSenderException {
            EmailIntentSender emailSender = new EmailIntentSender(getApplicationContext());
            emailSender.send(context, crashReportData);
        }
    }


    private void getOtherMessage(){
        String str = getPackageName();
        if (str.contains(".debug")){
            str = str.substring(0, str.length() - 6);
        } else if (str.contains(".debugUat")){
            str = str.substring(0, str.length() - 9);
        }
        ConfigPermission.APPLICATION_PACKAGE = str;
        // resValue 资源文件调用
        Log.d("---> app_token ",getResources().getString(R.string.app_token));
        Log.d("---> rel ",getResources().getBoolean(R.bool.rel)+"");
        Log.d("---> num ",getResources().getInteger(R.integer.num)+"");
        Log.d("---> base_url ",getResources().getString(R.string.base_url));
        Log.d("---> mall_base_url ",getResources().getString(R.string.mall_base_url));
        Log.d("---> app_client ",getResources().getString(R.string.app_client));

        // buildConfigField 配置文件调用
        Log.d("---> QQ_APPID ",BuildConfig.QQ_APPID);
        Log.d("---> LOG_DEBUG ",BuildConfig.LOG_DEBUG + "");
        Log.d("---> APPLICATION_ID ",BuildConfig.APPLICATION_ID);


        Log.d("---> VersionCode  ",getAppVersionCode(this));
        Log.d("---> VersionName  ",getAppVersionName(this));

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


    private void parseManifests() {
        String packageName = getApplicationContext().getPackageName();
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(packageName, PackageManager.GET_META_DATA);
            if (appInfo.metaData != null) {
                String appid = appInfo.metaData.getString("PUSH_APPID");
                String appsecret = appInfo.metaData.getString("PUSH_APPSECRET");
                String appkey = appInfo.metaData.getString("PUSH_APPKEY");

                Log.d("---> PUSH_APPID ",appid + "");
                Log.d("---> PUSH_APPSECRET ",appsecret + "");
                Log.d("---> PUSH_APPKEY ",appkey + "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 返回当前程序版本号
     */
    public static String getAppVersionCode(Context context) {
        int versioncode = 0;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versioncode = pi.versionCode;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versioncode + "";
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName=null;
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }



    /**
     * 初始化多环境打包
     */
    private void initMultiPackage() {
        switch (envType) {
            case EnvType.DEVELOP:
                //开发环境（
                MY_STR = "开发环境";
                break;
            case EnvType.CHECK:
                //测试环境
                MY_STR = "测试环境";
                break;
            case EnvType.PRODUCT:
                //生产环境
                MY_STR = "生产环境";
                break;
        }
    }

}




















