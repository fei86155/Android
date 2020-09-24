package com.example.android.app;

import android.app.Application;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.example.android.BuildConfig;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 9:48
 * Update Date:
 * Modified By:
 * Description:
 */
public class BaseApplication extends Application implements Thread.UncaughtExceptionHandler {
    private static BaseApplication sInstance;

    public static BaseApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        StatisticsHelper.getsInstance().inject(this);
        initArouter();
        Utils.init(this);

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        StatisticsHelper.getsInstance().unInject(this);
        ARouter.getInstance().destroy();
    }

    private void initArouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }


    public BaseApplication getsInstance() {
        return sInstance;
    }

    @Override
    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable throwable) {
        LogUtils.e("uncaught exception:" + throwable.toString());
    }
}
