package com.example.z_lib_common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

/**
 *
 * Description  <p>可以禁止滑动翻页的ViewPager </p>
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/7/9 17:39
 */
public class NoScrollViewPager extends ViewPager {

    private boolean isPagingEnabled = true;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    public void setPagerEnabled(boolean b) {
        this.isPagingEnabled = b;
    }

}
