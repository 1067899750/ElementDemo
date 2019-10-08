package com.example.z_lib_common.base.mvp;

import com.example.z_lib_common.base.mvc.activity.BaseActionBarActivity;

/**
 *
 * @description activity 基类
 * @author puyantao
 * @date 2019/10/8 14:12
 */
public abstract class BaseMvpActivity<M extends Model, V extends View, P extends BasePresenter>
        extends BaseActionBarActivity implements BaseMvp<M, V, P> {

    protected P presenter;

    @Override
    protected void afterInit() {
        super.afterInit();
        //创建Presenter
        presenter = createPresenter();
        if (presenter != null) {
            //将Model层注册到Presenter中
            presenter.registerModel(createModel());
            //将View层注册到Presenter中
            presenter.registerView(createView());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            //Activity销毁时的调用，让具体实现BasePresenter中onViewDestroy()方法做出决定
            presenter.destroy();
        }
    }
}













