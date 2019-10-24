package com.example.z_lib_girl;


import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.modulebase.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_girl.main.GirlsActivity;


/**
 * @author puyantao
 * @description
 * @date 2019/9/25 17:10
 */
@Route(path = ARouterUtils.GIRLS_MAIN_FRAGMENT)
public class GirlsMainFragment extends BaseFragment {

    public GirlsMainFragment() {
        // Required empty public constructor
    }

    public static GirlsMainFragment newInstance() {
        GirlsMainFragment fragment = new GirlsMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected int setLayoutId() {
        return R.layout.girl_fragment_main_girls;
    }

    @Override
    protected void initViews(View view) {
    }

    @Override
    protected void initData() {
        GirlsActivity.startGirlsActivity(getContext());
    }


    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isVisible() && !hidden){
            GirlsActivity.startGirlsActivity(getContext());
        }
    }


}
















