package com.example.z_lib_common.base.mvp;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 14:05
 */
public interface BaseMvp<M extends Model, V extends View, P extends BasePresenter> {
    /**
     *  创建Model
     * @return
     */
    M createModel();

    /**
     *  创建视图
     * @return
     */
    V createView();

    /**
     * 创建Presenter
     * @return
     */
    P createPresenter();
}
