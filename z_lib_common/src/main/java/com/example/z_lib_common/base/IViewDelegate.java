package com.example.z_lib_common.base;


import android.support.annotation.Keep;
import android.view.View;

/**
 *
 * Description <p>类说明</p>
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 17:38
 */
@Keep
public interface IViewDelegate {

    BaseFragment getFragment(String name);

    View getView(String name);

}
