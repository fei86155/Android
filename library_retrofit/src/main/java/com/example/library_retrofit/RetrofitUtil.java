package com.example.library_retrofit;

import com.example.library_retrofit.base.BaseRetrofit;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 10:38
 * Update Date:
 * Modified By:
 * Description:
 */
public class RetrofitUtil extends BaseRetrofit {

    private static RetrofitUtil sInstance;

    public static RetrofitUtil getInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitUtil();
        }
        return sInstance;
    }

    public ApiService getHttpService() {
        return getRetrofit().create(ApiService.class);
    }
}
