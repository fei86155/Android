package com.example.android.app;

import android.app.Activity;

import androidx.fragment.app.Fragment;

import java.util.Stack;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 14:11
 * Update Date:
 * Modified By:
 * Description:
 */
public class AppManager {
    private static AppManager appManager;
    private static Stack<Activity> activitieStacks = new Stack<>();
    private static Stack<Fragment> fragmentStacks = new Stack<>();

    public static AppManager getInstance() {
        if (appManager == null) {
            synchronized (AppManager.class) {
                if (appManager == null) {
                    appManager = new AppManager();
                }
            }
        }
        return appManager;
    }

    public void addActivity(Activity activity) {
        activitieStacks.add(activity);
    }

    public void removeActivity(Activity activity) {
        activitieStacks.remove(activity);
    }



}
