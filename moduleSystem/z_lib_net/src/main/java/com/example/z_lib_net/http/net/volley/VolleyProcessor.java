package com.example.z_lib_net.http.net.volley;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.z_lib_net.http.base.ICallBack;
import com.example.z_lib_net.http.base.IHttpProcessor;
import com.example.z_lib_net.utils.NetUtils;
import com.example.z_lib_net.utils.StringUtils;

import java.util.Map;

/**
 * @Describe
 * @Author puyantao
 * @Email 1067899750@qq.com
 * @create 2019/5/13 14:19
 */
public class VolleyProcessor implements IHttpProcessor {
    private final static String TAG = "VolleyProcessor";

    private static RequestQueue mQueue = null;

    public VolleyProcessor(Context context) {
        mQueue = Volley.newRequestQueue(context);

    }

    @Override
    public void get(final String url, Map<String, String> params, final ICallBack callBack) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Log.d(TAG, "onSuccess response==" + response);
                        callBack.onSuccess(StringUtils.getUrlTag(url), response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String toString = "null";
                        if (error != null) {
                            toString = error.toString();
                        }
                        Log.d(TAG, "onErrorResponse error ==" + toString);
                        callBack.onFailed(error.toString());
                    }
                });

        mQueue.add(stringRequest);

    }

    @Override
    public void post(final String url, Map<String, String> params, final ICallBack callBack) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onSuccess response==" + response);
                callBack.onSuccess(StringUtils.getUrlTag(url), response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String toString = "null";
                if (error != null) {
                    toString = error.toString();
                }
                Log.d(TAG, "onErrorResponse error ==" + toString);
                callBack.onFailed(error.toString());
            }
        });

        mQueue.add(stringRequest);
    }


}






















