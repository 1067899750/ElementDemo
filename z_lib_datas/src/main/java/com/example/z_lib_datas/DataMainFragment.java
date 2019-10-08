package com.example.z_lib_datas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/25 15:18
 */
@Route(path = ARouterUtils.DATA_MAIN_FRAGMENT)
public class DataMainFragment extends BaseFragment {



    public DataMainFragment() {
        // Required empty public constructor
    }


    public static DataMainFragment newInstance() {
        DataMainFragment fragment = new DataMainFragment();
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
        return R.layout.data_fragment_data_main;
    }

    @Override
    protected void initViews(View view) {
        super.initViews(view);
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
