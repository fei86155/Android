package com.example.android.ui.splash;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.room.Room;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.LogUtils;
import com.example.android.R;
import com.example.android.app.BaseApplication;
import com.example.android.arouter.BridgeConstants;
import com.example.android.base.BaseMvpActivity;
import com.example.android.db.AppDatabase;
import com.example.android.db.entity.User;
import com.example.android.utils.AnimUtil;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 9:20
 * Update Date:
 * Modified By:
 * Description: 启动页
 */
public class SplashActivity extends BaseMvpActivity<SplashPresenter> implements ISplashView{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected int getLayoutView() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        mPresenter.startCountDown();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void countDownSuccess() {
        doJump();

    }

    private void doJump() {
        ARouter.getInstance().build(BridgeConstants.MAIN).withOptionsCompat(AnimUtil.initArouterAnim()).navigation();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
