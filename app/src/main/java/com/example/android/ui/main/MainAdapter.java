package com.example.android.ui.main;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 17:08
 * Update Date:
 * Modified By:
 * Description:
 */
public class MainAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private String[] titles;

    public MainAdapter(@NonNull FragmentManager fm, int behavior, List<Fragment> fragmentList, String[] titles) {
        super(fm, behavior);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }


}
