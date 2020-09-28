package com.example.android.ui.main.home.more;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.android.R;
import com.example.android.app.BaseApplication;
import com.google.android.material.textfield.TextInputEditText;

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
        CheckBox cbBg = helper.getView(R.id.cb_bg);
        cbBg.setOnCheckedChangeListener((buttonView, isChecked) -> {
//                helper.setChecked(R.id.view_select_icon, isChecked);
            View view = helper.getView(R.id.view_select_icon);
            view.setSelected(isChecked);
        });

    }
}
