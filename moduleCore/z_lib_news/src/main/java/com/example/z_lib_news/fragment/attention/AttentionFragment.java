package com.example.z_lib_news.fragment.attention;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.z_lib_common.base.mvc.fragment.BaseMvcActionBarFragment;
import com.example.z_lib_common.base.mvc.fragment.BaseMvcFragment;
import com.example.z_lib_news.R;
import com.google.gson.JsonObject;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/11/6 16:16
 */
public class AttentionFragment extends BaseMvcFragment {
    private FloatingActionButton mFloatingActionButton;
    private TextView mTextView;
    private ImageView mImageView;

    public AttentionFragment() {
        // Required empty public constructor
    }

    public static AttentionFragment newInstance() {
        AttentionFragment fragment = new AttentionFragment();
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
        return R.layout.news_fragment_attention;
    }

    @Override
    protected void initViews(View root) {
        mFloatingActionButton = root.findViewById(R.id.fab_icon);
        mTextView = root.findViewById(R.id.tv_content);
        mImageView = root.findViewById(R.id.iv_main_backdrop);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void onSuccess(String tag, JsonObject jsonObject) {

    }

    @Override
    public void onFailed(String message) {

    }

    @Override
    public void onError(int code, String message) {

    }
}
