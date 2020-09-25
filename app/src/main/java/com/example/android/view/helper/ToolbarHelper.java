package com.example.android.view.helper;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.example.android.R;
import com.example.android.view.StatusbarUtil;

import org.w3c.dom.Text;

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

    public ToolbarHelper(Toolbar toolbar) {
        this.mToolbar = toolbar;
        if (toolbar == null) {
            throw new IllegalArgumentException("layout must include toolbar");
        }
        tvTitle = toolbar.findViewById(R.id.tv_title);
        viewStatusBar = toolbar.findViewById(R.id.view_statusbar_margin);
        mBaseContainer = mToolbar.findViewById(R.id.toolbar_base_container);
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }


    public void setImmersive(boolean isImmersive) {
        if (isImmersive) {

        } else {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.height = StatusbarUtil.getStatusbarHeight();
            viewStatusBar.setLayoutParams(layoutParams);

            /*ConstraintSet set = new ConstraintSet();
            set.clone(mBaseContainer);
            set.constrainHeight(R.id.view_statusbar_margin, statusBarHeight);
            set.applyTo(mBaseContainer);*/

        }
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }
}
