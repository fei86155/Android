package com.example.android.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 9:49
 * Update Date:
 * Modified By:
 * Description:
 */
public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements IView {
    protected T mPresenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        super.onCreate(savedInstanceState);
    }

    protected abstract T createPresenter();

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }



}
