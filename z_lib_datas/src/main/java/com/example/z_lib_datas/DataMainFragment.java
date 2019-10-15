package com.example.z_lib_datas;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.mvc.fragment.BaseMvcFragment;
import com.example.z_lib_common.http.HttpHelper;
import com.example.z_lib_common.http.Url;
import com.example.z_lib_common.http.net.retrofit.dns.HttpDns;
import com.google.gson.JsonObject;

import java.util.HashMap;


/**
 *
 * @description
 * @author puyantao
 * @date 2019/9/25 15:18
 */
@Route(path = ARouterUtils.DATA_MAIN_FRAGMENT)
public class DataMainFragment extends BaseMvcFragment {
    private TextView mTextView;


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
        mTextView = view.findViewById(R.id.tv);
    }

    @Override
    protected void initData() {
        HashMap<String, String> otherMap = new HashMap<>();
        HttpHelper.getInstance().post(HttpDns.baseUrl + Url.GIT_USER_MERCHANT, otherMap, this);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {
        String message = jsonObject.toString();
        if (tag.equals("billHomePage")) {
            System.out.println("--->" + Thread.currentThread());
            mTextView.setText(message);
        }
    }

    @Override
    public void onFailed(String message) {
        System.out.println("--->" + Thread.currentThread());
        mTextView.setText(message);
    }

    @Override
    public void onError(int code, String message) {
        System.out.println("--->" + Thread.currentThread());
        mTextView.setText(code + ":" + message);
    }


}
