package com.example.android.test;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/29 14:45
 * Update Date:
 * Modified By:
 * Description:
 */
public class TestCheckBox extends CheckBox {
    public TestCheckBox(@NonNull Context context) {
        super(context);
    }

    public TestCheckBox(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TestCheckBox(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        return false;
    }
}
