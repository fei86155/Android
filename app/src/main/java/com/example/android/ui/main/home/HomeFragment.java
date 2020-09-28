package com.example.android.ui.main.home;


import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.android.R;
import com.example.android.base.BaseFragment;
import com.example.android.view.StatusbarUtil;
import com.example.android.view.layout.MultiStatusLayout;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;

/**
 * Author: xxbi
 * Create Date: Created in 2020/9/24 17:17
 * Update Date:
 * Modified By:
 * Description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeView {
    @BindView(R.id.view_status_bar)
    View viewStatusbar;
    @BindView(R.id.tl_navigation)
    TabLayout tlNavigation;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.msl_container)
    MultiStatusLayout mslContainer;

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
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.height = StatusbarUtil.getStatusbarHeight();
        viewStatusbar.setLayoutParams(layoutParams);

        vpContainer.setAdapter(new HomeAdapter(getContext()));
        tlNavigation.setupWithViewPager(vpContainer);

//        mslContainer.addViewByState(MultiStatusLayout.ViewState.STATE_LOADING_VALUE, R.drawable.icon_homepage_mian, "Loading......", "", null);
        mslContainer.setCurrentViewState(MultiStatusLayout.ViewState.STATE_CONTENT_VALUE);
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

}
