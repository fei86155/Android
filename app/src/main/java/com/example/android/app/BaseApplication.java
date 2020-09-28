package com.example.android.app;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.example.android.BuildConfig;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

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
        initUtils();
        initXGPush();


    }

    private void initUtils() {
        Utils.init(this);
    }

    private void initXGPush() {
        //信鸽推送
        if (BuildConfig.DEBUG) {
            XGPushConfig.enableDebug(this,true);
        }
        XGPushManager.registerPush(this, new XGIOperateCallback() {
            @Override
            public void onSuccess(Object data, int flag) {
                //token在设备卸载重装的时候有可能会变
                Log.d("TPush", "注册成功，设备token为：" + data);
            }

            @Override
            public void onFail(Object data, int errCode, String msg) {
                Log.d("TPush", "注册失败，错误码：" + errCode + ",错误信息：" + msg);
            }
        });
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
