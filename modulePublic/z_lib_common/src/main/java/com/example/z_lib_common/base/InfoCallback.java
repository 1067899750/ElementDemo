package com.example.z_lib_common.base;

import android.support.annotation.Keep;

/**
 *
 * Description <p>数据回调接口</p>
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 17:38
 */
@Keep
public interface InfoCallback<T> {

    void onSuccess(T info);

    void onError(int code, String message);

}
