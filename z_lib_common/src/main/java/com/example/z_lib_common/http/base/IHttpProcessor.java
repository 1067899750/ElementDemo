package com.example.z_lib_common.http.base;

import java.util.Map;

/**
 * @Describe 代理接口 代理和真正干活的类  的 共同实现的接口
 * @Author puyantao
 * @Email 1067899750@qq.com
 * @create 2019/5/13 14:03
 */
public interface IHttpProcessor {


    /**
     *  Get 请求
     * @param url
     * @param params 参数
     * @param callBack 回调
     */
    void get(String url, Map<String, String> params, ICallBack callBack);

    /**
     *  Post 请求
     * @param url
     * @param params 参数
     * @param callBack 回调
     */
    void post(String url, Map<String, String> params, ICallBack callBack);

    //Update


    //Delete


}














