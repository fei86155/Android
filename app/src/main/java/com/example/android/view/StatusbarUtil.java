package com.example.android.view;

import com.example.android.app.BaseApplication;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 14:23
 * Update Date:
 * Modified By:
 * Description:
 */
public class StatusbarUtil {

    public static int getStatusbarHeight() {
        int statusbarRes = BaseApplication.getInstance().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (statusbarRes > 0) {
            return  BaseApplication.getInstance().getResources().getDimensionPixelSize(statusbarRes);
        }
        return 0;
    }
}
