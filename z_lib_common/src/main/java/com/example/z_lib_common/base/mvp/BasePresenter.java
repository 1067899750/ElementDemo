package com.example.z_lib_common.base.mvp;

import java.lang.ref.WeakReference;
/**
 *
 * @description presenter 基类
 * @author puyantao
 * @date 2019/10/8 14:10
 */
public abstract class BasePresenter<M extends Model, V extends View> implements Presenter<M, V> {
    /**
     * 使用弱引用来防止内存泄漏
     */
    private WeakReference<V> wrf;
    protected M model;

    @Override
    public void registerModel(M model) {
        this.model = model;
    }

    @Override
    public void registerView(V view) {
        wrf = new WeakReference<V>(view);
    }

    @Override
    public V getView() {
        return wrf == null ? null : wrf.get();
    }

    /**
     * 在Activity或Fragment卸载时调用View结束的方法
     */
    @Override
    public void destroy() {
        if (wrf != null) {
            wrf.clear();
            wrf = null;
        }
        onViewDestroy();
    }

    /**
     *  销毁试图
     */
    protected abstract void onViewDestroy();
}














