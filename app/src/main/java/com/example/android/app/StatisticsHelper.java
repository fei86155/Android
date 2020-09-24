package com.example.android.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 14:08
 * Update Date:
 * Modified By:
 * Description:
 */
public class StatisticsHelper {
    private static StatisticsHelper sInstance;

    public static StatisticsHelper getsInstance() {
        if (sInstance == null) {
            sInstance = new StatisticsHelper();
        }
        return sInstance;
    }

    public void inject(Application application) {
        application.registerActivityLifecycleCallbacks(callbacks);
    }

    public void unInject(Application application) {
        application.unregisterActivityLifecycleCallbacks(callbacks);
    }

    Application.ActivityLifecycleCallbacks callbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            AppManager.getInstance().addActivity(activity);
        }

        @Override
        public void onActivityStarted(@NonNull Activity activity) {

        }

        @Override
        public void onActivityResumed(@NonNull Activity activity) {

        }

        @Override
        public void onActivityPaused(@NonNull Activity activity) {

        }

        @Override
        public void onActivityStopped(@NonNull Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(@NonNull Activity activity) {
            AppManager.getInstance().removeActivity(activity);
        }
    };
}
