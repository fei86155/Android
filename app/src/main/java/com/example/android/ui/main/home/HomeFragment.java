package com.example.android.ui.main.home;


import android.view.View;
import android.view.ViewGroup;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.android.R;
import com.example.android.base.BaseFragment;
import com.example.android.view.StatusbarUtil;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * Author: xxbi
 * Create Date: Created in 2020/9/24 17:17
 * Update Date:
 * Modified By:
 * Description:
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeView{
    @BindView(R.id.view_status_bar)
    View viewStatusbar;
    @BindView(R.id.tl_navigation)
    TabLayout tlNavigation;
    @BindView(R.id.vp_container)
    ViewPager vpContainer;

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

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
