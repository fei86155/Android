package com.example.android.ui.main;

import android.view.KeyEvent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.android.R;
import com.example.android.arouter.BridgeConstants;
import com.example.android.base.BaseMvpActivity;
import com.example.android.ui.main.home.HomeFragment;
import com.example.android.ui.main.service.ServiceFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

@Route(path = BridgeConstants.MAIN)
public class MainActivity extends BaseMvpActivity<MainPresenter> {
    @BindView(R.id.vp_container)
    ViewPager vpContainer;
    @BindView(R.id.tl_navigation)
    TabLayout tlNavigation;
    MainAdapter mAdapter;
    private float mExitTime;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        initTabView();
    }

    private void initTabView() {
        String[] titles = new String[]{"首页", "次页", "首页", "次页"};
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ServiceFragment());




        mAdapter = new MainAdapter(getSupportFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragmentList, titles);
        vpContainer.setAdapter(mAdapter);
        tlNavigation.setupWithViewPager(vpContainer);

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - mExitTime < 2000) {
                finish();
            } else {
                mExitTime = System.currentTimeMillis();
                Toast.makeText(this, "Please press back twice quickly", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }
}