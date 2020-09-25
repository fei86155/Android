package com.example.android.ui.main.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.example.android.R;
import com.example.android.arouter.BridgeConstants;
import com.example.android.arouter.BridgeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 14:38
 * Update Date:
 * Modified By:
 * Description:
 */
public class HomeAdapter extends PagerAdapter {
    private final Context context;
    private String[] titles;
    private List<View> viewList = new ArrayList<>();

    private LinearLayout llContainer;
    private TextView tvMore;

    @Override
    public int getCount() {
        return viewList.size();
    }

    public HomeAdapter(Context context) {
        this.context = context;

        titles = new String[]{"A", "B"};

        viewList.add(LayoutInflater.from(context).inflate(R.layout.item_horizontal_scroll, null));

        //添加线性布局，一行四个总共两行八个。其余的显示在更多中。
        llContainer = viewList.get(0).findViewById(R.id.ll_container);
        tvMore = viewList.get(0).findViewById(R.id.tv_more);
        tvMore.setOnClickListener(view -> {
            BridgeUtil.bridgeWithAnim(BridgeConstants.HOMEMORE);
        });


    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        int pos =viewList.indexOf(object);
        if (pos < 0) {
            return POSITION_NONE;
        } else {
            return pos;
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeViewAt(position);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
