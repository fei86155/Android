package com.example.android.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.android.R;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/29 17:50
 * Update Date:
 * Modified By:
 * Description:
 */
public class CommonItemView extends LinearLayout {
    int ivLeftRef;
    String tvDesc;
    int ivRightRef;

    public CommonItemView(Context context) {
        super(context);
        init(null,context);
    }

    public CommonItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs,context);
    }

    public CommonItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs,context);
    }

    public CommonItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs,context);
    }

    private void init(AttributeSet attrs, Context context) {
        TypedArray ta = context.obtainStyledAttributes(attrs,R.styleable.CommonItemView);
        ivLeftRef = ta.getResourceId(R.styleable.CommonItemView_image_left, -1);
        ivRightRef = ta.getResourceId(R.styleable.CommonItemView_image_right, -1);
        tvDesc = ta.getString(R.styleable.CommonItemView_text_center);

        ta.recycle();
        initView();
    }

    private void initView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_common_view, this, false);
        ImageView ivLeft = view.findViewById(R.id.iv_left);
        ImageView ivRight = view.findViewById(R.id.iv_right);
        TextView tvCenter = view.findViewById(R.id.tv_desc);

        if (ivLeftRef > 0) {
            ivLeft.setImageResource(ivLeftRef);
        }

        if (ivRightRef > 0) {
            ivRight.setImageResource(ivRightRef);
        }

        if (!TextUtils.isEmpty(tvDesc)) {
            tvCenter.setText(tvDesc);
        }

    }


}
