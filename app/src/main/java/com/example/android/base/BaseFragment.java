package com.example.android.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 11:50
 * Update Date:
 * Modified By:
 * Description:
 */
public abstract class BaseFragment<T extends BasePresenter> extends RxFragment implements IView {
    private T mPresenter;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutView(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }

        initView();
        initListener();
        initData();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        mPresenter.detachView();
    }

    protected abstract int getLayoutView();

    protected abstract T createPresenter();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();
}
