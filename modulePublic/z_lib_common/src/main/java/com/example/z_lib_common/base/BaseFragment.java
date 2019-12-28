package com.example.z_lib_common.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Keep;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.z_lib_common.R;
import com.example.z_lib_common.utils.CommonUtils;
import com.gyf.barlibrary.ImmersionBar;


/**
 * @author puyantao
 * @description Fragment的基类
 * @date 2019/9/26 10:53
 */
@Keep
public abstract class BaseFragment extends Fragment {
    protected BaseActivity mActivity;
    protected FrameLayout flRoot;
    protected FrameLayout flActionBar;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.common_fragment_base, container, false);
        flRoot = view.findViewById(R.id.fl_root);
        flActionBar = view.findViewById(R.id.fl_action_bar);
        if (setLayoutId() != 0) {
            //用XML试图形式设置内容
            getLayoutInflater().inflate(setLayoutId(), flRoot);
        }else if (setConnectView() != null) {
            //用试图形式设置内容
            flRoot.addView(setConnectView());

        }
        beforeInit();
        initViews(view);
        initData();
        return view;
    }

    /**
     * 用XML文件设置，页面布局,
     *
     * @return
     */
    protected @LayoutRes
    int setLayoutId() {
        return 0;
    }

    /**
     * 设置内容, 直接用View试图代替
     *
     * @return
     */
    protected View setConnectView() {
        return null;
    }


    /**
     * 配置fragment 初始化环境
     */
    protected void beforeInit() {
    }

    /**
     * 初始化 root
     *
     * @param root
     */
    protected abstract void initViews(View root);

    /**
     * 初始化数据
     */
    protected abstract void initData();


    /**
     * 获取宿主Activity
     *
     * @return BaseActivity
     */
    protected BaseActivity getHoldingActivity() {
        return mActivity;
    }


    /****************************************************************/


    /**
     * 添加fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void addFragment(BaseFragment fragment, @IdRes int frameId) {
        CommonUtils.checkNotNull(fragment);
        getHoldingActivity().addFragment(fragment, frameId);

    }


    /**
     * 替换fragment
     *
     * @param fragment
     * @param frameId
     */
    protected void replaceFragment(BaseFragment fragment, @IdRes int frameId) {
        CommonUtils.checkNotNull(fragment);
        getHoldingActivity().replaceFragment(fragment, frameId);
    }


    /**
     * 隐藏fragment
     *
     * @param fragment
     */
    protected void hideFragment(BaseFragment fragment) {
        CommonUtils.checkNotNull(fragment);
        getHoldingActivity().hideFragment(fragment);
    }


    /**
     * 显示fragment
     *
     * @param fragment
     */
    protected void showFragment(BaseFragment fragment) {
        CommonUtils.checkNotNull(fragment);
        getHoldingActivity().showFragment(fragment);
    }


    /**
     * 移除Fragment
     *
     * @param fragment
     */
    protected void removeFragment(BaseFragment fragment) {
        CommonUtils.checkNotNull(fragment);
        getHoldingActivity().removeFragment(fragment);

    }


    /**
     * 弹出栈顶部的Fragment
     */
    protected void popFragment() {
        getHoldingActivity().popFragment();
    }

}
