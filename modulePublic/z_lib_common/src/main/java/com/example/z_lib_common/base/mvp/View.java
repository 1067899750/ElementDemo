package com.example.z_lib_common.base.mvp;

/**
 *
 * @description 试图接口
 * @author puyantao
 * @date 2019/10/8 14:07
 */
public interface View {
    /**
     *  显示toast
     * @param info
     */
    void showToast(String info);

    /**
     * 显示 Progress
     */
    void showProgress();
}
