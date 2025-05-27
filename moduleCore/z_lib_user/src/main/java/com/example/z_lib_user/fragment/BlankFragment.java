package com.example.z_lib_user.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.z_lib_common.base.mvp.BaseMvpFragment;
import com.example.z_lib_user.R;
import com.example.z_lib_user.fragment.model.BlackModel;
import com.example.z_lib_user.fragment.model.BlackModelImpl;
import com.example.z_lib_user.fragment.presenter.BlackPresenter;
import com.example.z_lib_user.fragment.view.BlackView;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 14:53
 */
public class BlankFragment extends BaseMvpFragment<BlackModel, BlackView, BlackPresenter> implements BlackView {
    private TextView tvHello;

    public BlankFragment() {
    }
    public static BlankFragment newInstance() {
        BlankFragment fragment = new BlankFragment();
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
        return R.layout.user_fragment_blank;
    }

    @Override
    protected void initViews(View view) {
        tvHello = view.findViewById(R.id.tv_hello);
        Button button = view.findViewById(R.id.btn_close);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    getActivity().finish();
                }
            }
        });
        presenter.getData();
    }


    @Override
    protected void initData() {

    }



    @Override
    @NonNull
    public BlackModel createModel() {
        return new BlackModelImpl();
    }

    @Override
    @NonNull
    public BlackView createView() {
        return this;
    }

    @Override
    @NonNull
    public BlackPresenter createPresenter() {
        return new BlackPresenter();
    }

    @Override
    public void setTextData(String str) {
        tvHello.setText(str);
    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showProgress() {

    }

}















