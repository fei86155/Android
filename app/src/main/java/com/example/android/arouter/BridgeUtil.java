package com.example.android.arouter;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.android.utils.AnimUtil;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 16:36
 * Update Date:
 * Modified By:
 * Description:
 */
public class BridgeUtil {

    public static void bridgeWithAnim(String path) {
        ARouter.getInstance().build(path).withOptionsCompat(AnimUtil.initArouterAnim()).navigation();
    }
}
