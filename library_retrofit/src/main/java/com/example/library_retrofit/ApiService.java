package com.example.library_retrofit;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 10:39
 * Update Date:
 * Modified By:
 * Description:
 */
public interface ApiService {
    @GET(" ")
    Observable<String> requestBaidu();
}
