package com.flavor;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class LLWelcomeBootPage extends LinearLayout {

    public final static int MAX_WELCOME_LENGTH = 1;



    private ImageView ivTop;
    private ImageView ivBottom;

    public LLWelcomeBootPage(Context context, int number) {
        super(context);
        if (number >= MAX_WELCOME_LENGTH) {
            return;
        }

    }
}