package com.example.library_retrofit.base;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 10:32
 * Update Date:
 * Modified By:
 * Description:
 */
public class BaseRetrofit {
    private static volatile Retrofit retrofit;
    private static final String BASE_URL = "";

    protected Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (BaseRetrofit.class) {
                if (retrofit == null) {
                    OkHttpClient client = new OkHttpClient.Builder()
                            .connectTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .build();

                    retrofit = new Retrofit.Builder()
                            .client(client)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl(BASE_URL)
                            .build();
                }
            }
        }
        return retrofit;
    }
}
