package com.example.z_lib_user.fragment.model;


import android.util.Log;
/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 14:52
 */
public class BlackModelImpl implements BlackModel {
    @Override
    public String getDataFromHWW() {
        return "data from net";
    }

    @Override
    public void stopRequest() {
        Log.i("model-stopped", "BlackModelImpl stop request...");
    }
}
