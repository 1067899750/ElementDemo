package com.flavor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.elementdemo.R;
import com.example.z_lib_common.base.BaseActivity;
import com.example.z_lib_main.MainActivity;

public class LLWelcomeBootPage  extends LinearLayout {

    public final static int MAX_WELCOME_LENGTH = 2;


    private ImageView ivTop;
    private ImageView ivBottom;

    public LLWelcomeBootPage(Context context, int number) {
        super(context);
        if (number >= MAX_WELCOME_LENGTH) {
            return;
        }
        LayoutInflater.from(context).inflate(R.layout.ll_boot_page_using, this, true);
        ivTop = (ImageView) findViewById(R.id.iv_top);
        if (1 == number) {
            setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    getContext().startActivity(intent);
                    ((BaseActivity) getContext()).finish();
                }
            });
        }
    }
}
