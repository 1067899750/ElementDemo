package com.example.z_lib_girl.girl;

import android.view.WindowManager;

import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_common.widget.HackyViewPager;
import com.example.z_lib_girl.Constants;
import com.example.z_lib_girl.data.bean.Girls;

import java.util.List;

/**
 *
 * @description
 * @author puyantao
 * @date 2019/10/8 9:53
 */
@Route(path = "/girls/detail")
public class GirlActivity extends BaseActivity {

    @Override
    protected int setLayoutId() {
        return 0;
    }

    @Override
    protected void initDate() {

    }


    @Override
    protected void initViews() {
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
