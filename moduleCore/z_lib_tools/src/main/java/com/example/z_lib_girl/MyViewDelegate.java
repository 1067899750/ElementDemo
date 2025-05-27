package com.example.z_lib_girl;

import android.view.View;

import androidx.annotation.Keep;

import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_common.base.IViewDelegate;


/**
 * <p>类说明</p>
 */
@Keep
public class MyViewDelegate implements IViewDelegate {

    @Override
    public BaseFragment getFragment(String name) {
        return GirlsMainFragment.newInstance();
    }

    @Override
    public View getView(String name) {
        return null;
    }
}
