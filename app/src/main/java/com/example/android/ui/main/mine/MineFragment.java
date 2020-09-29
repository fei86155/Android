package com.example.android.ui.main.mine;

import android.view.View;

import com.example.android.R;
import com.example.android.base.BaseFragment;
import com.example.android.ui.main.home.HomePresenter;
import com.example.android.view.StatusbarUtil;

import butterknife.BindView;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/29 17:31
 * Update Date:
 * Modified By:
 * Description:
 */
public class MineFragment extends BaseFragment<MinePresenter> implements IMineView {
    @BindView(R.id.view_status_bar)
    View viewStatusBar;

    @Override
    protected int getLayoutView() {
        return R.layout.fragment_mine;
    }

    @Override
    protected MinePresenter createPresenter() {
        return new MinePresenter();
    }

    @Override
    protected void initView() {
        viewStatusBar.getLayoutParams().height = StatusbarUtil.getStatusbarHeight();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
