package com.example.z_lib_datas;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/25 15:18
 */
@Route(path = ARouterUtils.DATA_MAIN_FRAGMENT)
public class DataMainFragment extends Fragment {



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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.data_fragment_data_main, container, false);
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
