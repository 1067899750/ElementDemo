package com.example.z_lib_user.fragment.presenter;


import android.util.Log;

import com.example.z_lib_common.base.mvp.BasePresenter;
import com.example.z_lib_user.fragment.model.BlackModel;
import com.example.z_lib_user.fragment.view.BlackView;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 14:52
 */
public class BlackPresenter extends BasePresenter<BlackModel, BlackView> {
    public void getData() {
        String dataFromNet = null;
        if (model != null) {
            dataFromNet = model.getDataFromHWW();
        }
        if (getView() != null) {
            getView().setTextData(dataFromNet);
        }
    }

    @Override
    protected void onViewDestroy() {
        Log.i("view-uninstall", "SecondActivity finished");
        if (model != null) {
            model.stopRequest();
        }
    }

}














