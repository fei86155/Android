package com.example.android.ui.main.service;

import android.view.View;
import android.widget.Button;
import android.widget.Scroller;
import android.widget.Toolbar;

import com.example.android.R;
import com.example.android.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 9:05
 * Update Date:
 * Modified By:
 * Description:
 */
public class ServiceFragment extends BaseFragment<ServicePresenter> implements IServiceView {

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_service;
    }

    @Override
    protected ServicePresenter createPresenter() {
        return new ServicePresenter();
    }

    @Override
    protected void initView() {
        provideToolbarHelper().setTitle("服务");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

}
