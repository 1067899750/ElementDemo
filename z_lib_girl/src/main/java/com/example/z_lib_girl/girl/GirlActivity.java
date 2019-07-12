package com.example.z_lib_girl.girl;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.widget.HackyViewPager;
import com.example.z_lib_girl.Constants;
import com.example.z_lib_girl.data.bean.Girls;

import java.util.List;


@Route(path = "/girls/detail")
public class GirlActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        if (getIntent() != null) {
            List<Girls> mData = getIntent().getParcelableArrayListExtra(Constants.INTENT_GIRLS);
            int mCurrentIndex = getIntent().getIntExtra(Constants.INTENT_INDEX, 0);
            HackyViewPager viewPager = new HackyViewPager(this);
            setContentView(viewPager);
            GirlAdapter adapter = new GirlAdapter(this, mData);
            viewPager.setAdapter(adapter);
            viewPager.setCurrentItem(mCurrentIndex);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        }
    }

}
