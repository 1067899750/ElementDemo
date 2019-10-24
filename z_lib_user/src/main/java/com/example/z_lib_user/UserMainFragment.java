package com.example.z_lib_user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.modulebase.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseFragment;
import com.example.z_lib_user.activity.UserMainActivity;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/25 15:26
 */
@Route(path = ARouterUtils.USER_MAIN_FRAGMENT)
public class UserMainFragment extends BaseFragment {
    private Button userBtn;

    public UserMainFragment() {
        // Required empty public constructor
    }

    public static UserMainFragment newInstance() {
        UserMainFragment fragment = new UserMainFragment();
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
        return R.layout.user_fragment_user_main;
    }

    @Override
    protected void initViews(View view) {
        userBtn = view.findViewById(R.id.user_btn);
    }

    @Override
    protected void initData() {
        userBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserMainActivity.startUserMainActivity(getActivity());
            }
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
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














