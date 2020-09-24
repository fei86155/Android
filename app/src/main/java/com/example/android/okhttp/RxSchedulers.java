package com.example.android.okhttp;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.components.RxFragment;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 13:31
 * Update Date:
 * Modified By:
 * Description:
 */
public class RxSchedulers {

    public static <T> ObservableTransformer<T, T> applySchedulers(final LifecycleProvider provider) {
        return upstream -> upstream.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(bindToLifecycle(provider));
    }

    private static <T> LifecycleTransformer<T> bindToLifecycle(LifecycleProvider provider) {
        if (provider instanceof RxAppCompatActivity) {
            return ((RxAppCompatActivity)provider).bindToLifecycle();
        } else if (provider instanceof RxFragment) {
            return ((RxFragment)provider).bindToLifecycle();
        } else {
            throw new IllegalArgumentException("class must extents RxAppCompatActivity or RxFragment");
        }
    }

}
