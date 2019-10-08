package com.example.z_lib_girl;


import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_girl.main.GirlsActivity;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/25 17:10
 */
@Route(path = ARouterUtils.GIRLS_MAIN_FRAGMENT)
public class GirlsMainFragment extends BaseFragment {

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GirlsMainFragment.
     */
    public static GirlsMainFragment newInstance() {
        return new GirlsMainFragment();
    }


    public GirlsMainFragment() {
        // Required empty public constructor
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
    }



}
















