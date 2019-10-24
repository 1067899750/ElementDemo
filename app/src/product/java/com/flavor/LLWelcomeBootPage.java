package com.flavor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.elementdemo.R;
import com.example.z_lib_base.arouter.ARouterUtils;


public class LLWelcomeBootPage extends LinearLayout {
    public final static int MAX_WELCOME_LENGTH = 5;

    private int[] mImageResList = {R.drawable.bg_middle_1, R.drawable.bg_middle_2, R.drawable.bg_middle_3,
            R.drawable.bg_middle_4, R.drawable.bg_middle_5};

    private ImageView ivWelcomeBg;
    private TextView tvWelcomeTop;
    private TextView tvWelcomeBottom;

    public LLWelcomeBootPage(final Context context, int number) {
        super(context);
        if (number >= MAX_WELCOME_LENGTH) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.ll_boot_page_using, this, true);
        if (number == 5) {
        }
    }
}
