package com.example.z_lib_common.imageloader.imagei;

import android.graphics.Bitmap;

/**
 *
 * @Description
 * @Author puyantao
 * @Date 2019/9/6 10:22
 */

public interface ImageDownLoadCallBack {

    void onDownLoadSuccess(Bitmap bitmap);

    void onDownLoadFailed();
}
