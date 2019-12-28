package com.example.z_lib_common.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.z_lib_common.R;
import com.example.z_lib_common.utils.ValueUtil;

/**
 * @author puyantao
 * @describe
 * @create 2019/9/27 16:30
 */
public class MyActionBar extends LinearLayout {
    private ImageView ivBack;
    private TextView tvTitle;
    private RelativeLayout rlActionBar;
    private Context mContext;

    public MyActionBar(Context context) {
        super(context);
        initView(context);
    }

    public MyActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(final Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.common_action_bar, this, true);
        ivBack = findViewById(R.id.iv_back);
        tvTitle = findViewById(R.id.tv_title);
        rlActionBar = findViewById(R.id.rl_action_bar);
        ivBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                scanForActivity(mContext).finish();
            }
        });
    }

    /**
     * 强制转换Activity
     *
     * @param cont
     * @return
     */
    private Activity scanForActivity(Context cont) {
        if (cont instanceof Activity) {
            return (Activity) cont;
        } else if (cont instanceof ContextWrapper) {
            return scanForActivity(((ContextWrapper) cont).getBaseContext());
        } else {
            return (Activity) cont;
        }
    }

    public ImageView getIvBack() {
        return ivBack;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    public void setTitle(String title) {
        if (ValueUtil.isStrNotEmpty(title)) {
            tvTitle.setText(title);
        }
    }

    /**
     * 设置actionBar的背景颜色
     *
     * @param color
     */
    public void setActionBarColor(int color) {
        rlActionBar.setBackgroundColor(color);
    }


}



















