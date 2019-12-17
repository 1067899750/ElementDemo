package com.example.z_lib_net.http.net.http;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.z_lib_net.http.base.ICallBack;
import com.example.z_lib_net.http.base.IHttpProcessor;
import com.example.z_lib_net.http.net.retrofit.dns.OKHttpDns;
import com.example.z_lib_net.http.net.retrofit.interceptor.AddSsionInterceptor;
import com.example.z_lib_net.http.net.retrofit.interceptor.AddTokenInterceptor;
import com.example.z_lib_net.http.net.retrofit.interceptor.GzipRequestInterceptor;
import com.example.z_lib_net.http.net.retrofit.interceptor.LogInterceptor;
import com.example.z_lib_net.http.net.retrofit.interceptor.ReadCookiesInterceptor;
import com.example.z_lib_net.http.net.retrofit.interceptor.RewriteCacheControlInterceptor;
import com.example.z_lib_net.utils.StringUtils;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * https://www.cnblogs.com/JamesWang1993/p/8593494.html
 * https://blog.csdn.net/Double2hao/article/details/83744659
 *
 * Description
 * Author puyantao
 * Email 1067899750@qq.com
 * Date 2019/5/13 14:31
 */

public class OkHttpProcessor implements IHttpProcessor {
    private final String TAG = "OkHttpProcessor";

    private OkHttpClient mOkHttpClient;

    private Handler myHandler;

    public OkHttpProcessor(Context context) {
        mOkHttpClient = new OkHttpClient.Builder()
                //向HTTP中写入ssionId
                .addInterceptor(new AddSsionInterceptor())
                //从HTTP中读取cookie
                .addInterceptor(new ReadCookiesInterceptor())
                .addInterceptor(new LogInterceptor())
//                .addInterceptor(new LoginInterceptor())
                .addInterceptor(new GzipRequestInterceptor())
                .addInterceptor(new RewriteCacheControlInterceptor(context))
                //向HTTP中写入token
                .addInterceptor(new AddTokenInterceptor())
                .dns(new OKHttpDns(100))
//                .dns(new OkDns())
                .build();
//        mOkHttpClient = new OkHttpClient();
        myHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void get(final String url, Map<String, String> params, final ICallBack callBack) {
        final Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        mOkHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, final IOException e) {
                        Log.d(TAG, "onFailure e ==" + e);
                        myHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                callBack.onFailed(e.toString());
                            }
                        });

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {
                        if (response == null) {
                            Log.d(TAG, "onSuccess response== null");
                            return;
                        }
                        Log.d(TAG, "onSuccess response==" + response.toString());
                        if (response.isSuccessful()) {
                            final String result = response.body().string();
                            Log.d(TAG, "onSuccess result==" + result);
                            myHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    callBack.onSuccess(StringUtils.getUrlTag(url), result);
                                }
                            });

                        } else {
                            myHandler.post(new Runnable() {
                                @Override
                                public void run() {
                                    callBack.onError(response.code(), response.message());
                                }
                            });

                        }
                    }
                });
    }

    @Override
    public void post(final String url, Map<String, String> params, final ICallBack callBack) {
        RequestBody requestbody = appendBody(params);

        final Request request = new Request.Builder()
                .post(requestbody)
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                Log.d(TAG, "onFailure e ==" + e);
                myHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onFailed(e.toString());

                    }
                });

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response == null) {
                    Log.d(TAG, "onSuccess response== null");
                    return;
                }
                Log.d(TAG, "onSuccess response==" + response.toString());
                if (response.isSuccessful()) {
                    final String result = response.body().string();

                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onSuccess(StringUtils.getUrlTag(url), result);
                        }
                    });
                } else {
                    myHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callBack.onError(response.code(), response.message());

                        }
                    });

                }
            }
        });


    }


    /**
     * 快速构建参数
     *
     * @param params
     * @return
     */
    private RequestBody appendBody(Map<String, String> params) {
        FormBody.Builder body = new FormBody.Builder();
        if (params == null || params.isEmpty()) {
            return body.build();
        }

        for (Map.Entry<String, String> entry :
                params.entrySet()) {
            body.add(entry.getKey(), entry.getValue().toString());
        }
        return body.build();
    }
}
