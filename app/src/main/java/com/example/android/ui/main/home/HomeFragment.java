package com.example.android.ui.main.home;


import com.example.android.R;
import com.example.android.base.BaseFragment;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 17:17
 * Update Date:
 * Modified By:
 * Description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeView{
    @Override
    protected int getLayoutView() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
