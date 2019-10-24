package com.example.z_lib_base.arouter;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 *
 * @description ARouter管理器
 * @author puyantao
 * @date 2019/10/24 10:47
 */
public class ARouterManager {

    public static void startNewsCanterActivity(){
        ARouter.getInstance().build(ARouterUtils.NEWS_CENTER).navigation();
    }


    public static void startGrilsListActivity(){
        ARouter.getInstance().build(ARouterUtils.GIRLS_LIST).navigation();
    }






}











