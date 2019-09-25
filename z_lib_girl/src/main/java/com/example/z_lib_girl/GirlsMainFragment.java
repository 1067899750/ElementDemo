package com.example.z_lib_girl;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.gril_fragment_main_girls, container, false);
        initView(view);
        intiData();
        return view;
    }



    private void initView(View view) {

    }

    private void intiData() {
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
















