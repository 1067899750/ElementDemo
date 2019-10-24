package com.example.z_lib_common.base.mvp;

import android.content.Context;

import com.example.z_lib_common.base.BaseFragment;

/**
 *
 * @description fragment 基类
 * @author puyantao
 * @date 2019/10/8 14:12
 */
public abstract class BaseMvpFragment<M extends Model, V extends View, P extends BasePresenter>
        extends BaseFragment implements BaseMvp<M, V, P> {
    protected P presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter = createPresenter();
        if (presenter != null) {
            presenter.registerModel(createModel());
            presenter.registerView(createView());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.destroy();
        }
    }
}



















