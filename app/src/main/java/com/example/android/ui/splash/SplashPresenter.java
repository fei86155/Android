package com.example.android.ui.splash;

import androidx.room.Room;

import com.blankj.utilcode.util.LogUtils;
import com.example.android.app.BaseApplication;
import com.example.android.base.BasePresenter;
import com.example.android.base.IModel;
import com.example.android.db.AppDatabase;
import com.example.android.db.entity.User;
import com.example.android.okhttp.RxSchedulers;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 10:04
 * Update Date:
 * Modified By:
 * Description:
 */
public class SplashPresenter extends BasePresenter<ISplashView, IModel> {
    public void startCountDown() {
        Disposable disposable = Observable.interval(2, 1, TimeUnit.SECONDS)
                .take(1)
                .compose(RxSchedulers.applySchedulers(getLifecycleProvider()))
                .subscribe(aLong -> getView().countDownSuccess());

        addDisposable(disposable);
    }
}
