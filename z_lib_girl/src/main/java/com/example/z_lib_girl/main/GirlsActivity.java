package com.example.z_lib_girl.main;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.arouter.ARouterUtils;
import com.example.z_lib_common.base.BaseActionBarActivity;
import com.example.z_lib_girl.R;

@Route(path = ARouterUtils.GRILS_LIST)
public class GirlsActivity extends BaseActionBarActivity {

    private GirlsView mView;
    private GirlsContract.Presenter mPresenter;

    @Override
    protected int setTitleId() {
        return R.string.gril_girls_activity_title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mView = new GirlsView(this);
        setContentView(mView);
        mPresenter = new GirlsPresenter(mView);
        mPresenter.start();
    }


}
