package com.example.android.ui.main.home.more;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.android.R;

import java.util.List;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 17:13
 * Update Date:
 * Modified By:
 * Description:
 */
public class HomeMoreAdapter extends BaseItemDraggableAdapter<HomeMoreEntity, BaseViewHolder> {

    public HomeMoreAdapter(@Nullable List<HomeMoreEntity> data) {
        super(R.layout.item_home_more, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, HomeMoreEntity item) {
        helper.setText(R.id.tv_content, item.getLabel());
    }
}
