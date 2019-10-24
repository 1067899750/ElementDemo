package com.example.z_lib_common.widget.annotation;

import android.support.annotation.IntDef;

import com.example.z_lib_common.widget.PageType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author puyantao
 * @describe 用来决定跳转到那个页面
 * @create 2019/9/25 14:09
 */
@IntDef({PageType.HOME_PAGE, PageType.NEWS_PAGE, PageType.DATA_PAGE, PageType.TOOL_PAGE, PageType.USER_CENTER_PAGE})
@Retention(RetentionPolicy.SOURCE)
public @interface PageTypeAnnotation {
}
