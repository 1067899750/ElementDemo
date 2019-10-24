package com.example.z_lib_common.base.mvp;

import android.graphics.Color;

import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.widget.MyActionBar;

/**
 *
 * @description activity 基类
 * @author puyantao
 * @date 2019/10/8 14:12
 */
public abstract class BaseMvpActivity<M extends Model, V extends View, P extends BasePresenter>
        extends BaseActivity implements BaseMvp<M, V, P> {

    protected P presenter;

    @Override
    protected void beforeInit() {
        super.beforeInit();
        //标题栏设置
        flActionBar.setVisibility(android.view.View.VISIBLE);
        MyActionBar actionBar = new MyActionBar(this);
        actionBar.setTitle(setTitle());
        actionBar.setActionBarColor(setActionBarColor());
        flActionBar.addView(actionBar);
    }

    /**
     * 设置默认标题
     *
     * @return 标题
     */
    protected abstract String setTitle();


    /**
     * 设置actionBar的背景颜色
     *
     * @return
     */
    public int setActionBarColor() {
        return Color.parseColor("#03A9F4");
    }


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













