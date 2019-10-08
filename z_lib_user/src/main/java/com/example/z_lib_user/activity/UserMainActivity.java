package com.example.z_lib_user.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.z_lib_common.base.mvp.BaseMvpActivity;
import com.example.z_lib_user.R;
import com.example.z_lib_user.activity.model.MainModel;
import com.example.z_lib_user.activity.model.MainModelImpl;
import com.example.z_lib_user.activity.presenter.MainPresenter;
import com.example.z_lib_user.activity.view.MainView;
import com.example.z_lib_user.fragment.BlankFragment;

/**
 * @author puyantao
 * @description
 * @date 2019/10/8 14:33
 */
public class UserMainActivity extends BaseMvpActivity<MainModel, MainView, MainPresenter> implements MainView {
    private TextView tvData;

    public static void startUserMainActivity(Activity activity){
        Intent instant = new Intent(activity, UserMainActivity.class);
        activity.startActivity(instant);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.user_activity_main;
    }

    @Override
    protected void initViews() {
        tvData = findViewById(R.id.tv_data);
        Button btnFirst = findViewById(R.id.btn_first);
        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnFirst.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.rl_content, BlankFragment.newInstance())
                        .commit();
            }
        });
    }

    @Override
    protected void initDate() {
        if (presenter != null) {
            presenter.getData();
        }
    }

    @Override
    protected String setTitle() {
        return "MVP Activity";
    }
    @Override
    public MainModel createModel() {
        return new MainModelImpl();
    }

    @Override
    public MainView createView() {
        return this;
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public void setData(String str) {
        tvData.setText(str);
    }

    @Override
    public void showToast(String info) {

    }

    @Override
    public void showProgress() {

    }


}
