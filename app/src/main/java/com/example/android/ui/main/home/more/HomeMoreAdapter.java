package com.example.android.ui.main.home.more;

import android.os.Build;
import android.view.View;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
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
    private boolean flag = false;

    public HomeMoreAdapter(@Nullable List<HomeMoreEntity> data) {
        super(R.layout.item_home_more, data);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void convert(BaseViewHolder helper, HomeMoreEntity item) {
        helper.setText(R.id.tv_content, item.getLabel());

        View view = helper.getView(R.id.view_select_icon);
        view.setSelected(false);

        helper.getView(R.id.cl_item_more).setOnClickListener(v -> {
            flag = !flag;
            view.setSelected(flag);
        });

        CheckBox checkBox = helper.getView(R.id.cb_bg);
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
//                helper.setChecked(R.id.view_select_icon, isChecked);
            view.setSelected(isChecked);
        });

    }
}
