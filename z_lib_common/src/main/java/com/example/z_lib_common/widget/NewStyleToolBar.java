package com.example.z_lib_common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import com.example.z_lib_common.R;
import com.example.z_lib_common.widget.annotation.PageTypeAnnotation;;

/**
 * @author puyantao
 * @description
 * @date 2019/9/25 15:35
 */
public class NewStyleToolBar extends LinearLayout implements View.OnClickListener {
    private RadioButton rbHome;
    private RadioButton rbInfo;
    private RadioButton rbData;
    private RadioButton rbTool;
    private RadioButton rbUser;

    private int mCurrentItem;
    private OnClickChildLocationListener mChildLocationListener;

    public NewStyleToolBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.new_style_tool_bar, this, true);
        rbHome = findViewById(R.id.bottom_home);
        rbHome.setOnClickListener(this);
        rbInfo = findViewById(R.id.bottom_info);
        rbInfo.setOnClickListener(this);
        rbData = findViewById(R.id.bottom_data);
        rbData.setOnClickListener(this);
        rbTool = findViewById(R.id.bottom_tool);
        rbTool.setOnClickListener(this);
        rbUser = findViewById(R.id.bottom_user);
        rbUser.setOnClickListener(this);

        setBackgroundColor(Color.TRANSPARENT);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NewStyleToolBar);
        mCurrentItem = typedArray.getInt(R.styleable.NewStyleToolBar_selectItem, 0);
        typedArray.recycle();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setRbPosition(mCurrentItem);
    }



    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        if (viewId == R.id.bottom_home){
            if (rbHome.isSelected()) {
                return;
            }
            setRbPosition(PageType.HOME_PAGE);
            mChildLocationListener.onChildPosition(PageType.HOME_PAGE);

        }else if (viewId == R.id.bottom_info){
            if (rbInfo.isSelected()) {
                return;
            }
            setRbPosition(PageType.NEWS_PAGE);
            mChildLocationListener.onChildPosition(PageType.NEWS_PAGE);

        }else if (viewId == R.id.bottom_data){
            if (rbData.isSelected()) {
                return;
            }
            setRbPosition(PageType.DATA_PAGE);
            mChildLocationListener.onChildPosition(PageType.DATA_PAGE);

        }else if (viewId == R.id.bottom_tool){
            if (rbTool.isSelected()) {
                return;
            }
            setRbPosition(PageType.TOOL_PAGE);
            mChildLocationListener.onChildPosition(PageType.TOOL_PAGE);

        }else if (viewId == R.id.bottom_user){
            if (rbUser.isSelected()) {
                return;
            }
            setRbPosition(PageType.USER_CENTER_PAGE);
            mChildLocationListener.onChildPosition(PageType.USER_CENTER_PAGE);

        }
    }

    /**
     * 设置rb的选着位置
     *
     * @param position
     */
    public void setRbPosition(@PageTypeAnnotation int position) {
        rbHome.setSelected(false);
        rbInfo.setSelected(false);
        rbData.setSelected(false);
        rbTool.setSelected(false);
        rbUser.setSelected(false);
        switch (position) {
            case PageType.HOME_PAGE: {
                rbHome.setSelected(true);
                break;
            }
            case PageType.NEWS_PAGE: {
                rbInfo.setSelected(true);
                break;
            }
            case PageType.DATA_PAGE: {
                rbData.setSelected(true);
                break;
            }
            case PageType.TOOL_PAGE: {
                rbTool.setSelected(true);
                break;
            }
            case PageType.USER_CENTER_PAGE: {
                rbUser.setSelected(true);
                break;
            }
        }
    }


    /**
     * 监听点击RadioGroup的位置
     *
     * @param locationListener
     */
    public void setClickChildLocationListener(OnClickChildLocationListener locationListener) {
        if (locationListener != null) {
            this.mChildLocationListener = locationListener;
        }
    }


    public interface OnClickChildLocationListener {
        /**
         * 监听回调底部导航栏
         *
         * @param position
         */
        void onChildPosition(@PageTypeAnnotation int position);
    }


}















