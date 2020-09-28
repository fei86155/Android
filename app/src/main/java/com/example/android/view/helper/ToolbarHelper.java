package com.example.android.view.helper;

import android.app.Activity;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.android.R;
import com.example.android.view.StatusbarUtil;

import java.util.function.ToLongBiFunction;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/25 9:46
 * Update Date:
 * Modified By:
 * Description:
 */
public class ToolbarHelper {
    private Toolbar mToolbar;
    private TextView tvTitle;
    private View viewStatusBar;
    private ConstraintLayout mBaseContainer;
    private LinearLayout llLeft;
    private LinearLayout llRight;

    public ToolbarHelper(Toolbar toolbar) {
        if (toolbar == null) {
            throw new IllegalArgumentException("layout must include toolbar");
        }
        this.mToolbar = toolbar;
        tvTitle = toolbar.findViewById(R.id.tv_title);
        viewStatusBar = toolbar.findViewById(R.id.view_statusbar_margin);
        mBaseContainer = toolbar.findViewById(R.id.toolbar_base_container);
        llLeft = toolbar.findViewById(R.id.ll_left);
        llRight = toolbar.findViewById(R.id.ll_right);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }


    public void setImmersive(boolean isImmersive) {
        if (!isImmersive) {

            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.height = StatusbarUtil.getStatusbarHeight();
            viewStatusBar.setLayoutParams(layoutParams);

            /*ConstraintSet set = new ConstraintSet();
            set.clone(mBaseContainer);
            set.constrainHeight(R.id.view_statusbar_margin, statusBarHeight);
            set.applyTo(mBaseContainer);*/

        }
    }

    public ToolbarHelper setTitle(String title) {
        tvTitle.setText(title);
        return this;
    }

    public ToolbarHelper enableRightButton() {
        TextView textView = new TextView(mToolbar.getContext());
        textView.setText("Reload");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llRight.addView(textView, layoutParams);
        return this;
    }

    public ToolbarHelper addRightButtonListener(@NonNull View.OnClickListener listener) {
        llRight.setOnClickListener(listener);
        return this;
    }

    public void enableBack(Activity activity) {
        ImageView imageView = new ImageView(mToolbar.getContext());
        imageView.setImageResource(R.drawable.icon_homepage_mian);
        TextView textView = new TextView(mToolbar.getContext());
        textView.setText("返回");
        textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        llLeft.addView(imageView, layoutParams);
        llLeft.addView(textView, layoutParams);

        llLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
    }
}
