package com.example.z_lib_common.base.mvp;
/**
 *
 * @description Presenter 接口
 * @author puyantao
 * @date 2019/10/8 14:07
 */
public interface Presenter<M extends Model, V extends View> {
    /**
     * 注册Model层
     *
     * @param model
     */
    void registerModel(M model);

    /**
     * 注册View层
     *
     * @param view
     */
    void registerView(V view);

    /**
     * 获取View
     *
     * @return
     */
    V getView();

    /**
     * 销毁动作（如Activity、Fragment的卸载）
     */
    void destroy();
}
