package com.example.z_lib_common.arouter;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @Describe  ARouter管理器
 * @Author puyantao
 * @Email 1067899750@qq.com
 * @create 2019/7/12 14:41
 */
public class ARouterManager {

    public static void startNewsCanterActivity(){
        ARouter.getInstance().build(ARouterUtils.NEWS_CENTER).navigation();
    }


    public static void startGrilsListActivity(){
        ARouter.getInstance().build(ARouterUtils.GRILS_LIST).navigation();
    }






}











