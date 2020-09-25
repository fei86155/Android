package com.example.android.utils;

import androidx.core.app.ActivityOptionsCompat;

import com.example.android.R;
import com.example.android.app.BaseApplication;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 18:57
 * Update Date:
 * Modified By:
 * Description:
 */
public class AnimUtil {
    public static ActivityOptionsCompat initArouterAnim() {
        return  ActivityOptionsCompat.makeCustomAnimation(BaseApplication.getInstance(), R.anim.anim_in_page, R.anim.anim_out_page);
    }
}
