package com.example.android.base;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.example.android.R;
import com.example.android.view.helper.ToolbarHelper;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/24 9:56
 * Update Date:
 * Modified By:
 * Description:
 */
public abstract class BaseActivity extends RxAppCompatActivity {
    private Unbinder unbinder;
    private ToolbarHelper mToolbarHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        initState();
        setContentView(getLayoutView());
        unbinder = ButterKnife.bind(this);

        initView();
        initListener();
        initData();
    }

    protected ToolbarHelper provideToolbarHelper() {
        provideToolbar();
        return mToolbarHelper;
    }

    private void provideToolbar() {
        if (mToolbarHelper == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            if (toolbar == null) {
                throw new IllegalArgumentException("Toolbar must be defined in layout");
            }
            mToolbarHelper = new ToolbarHelper(toolbar);
            mToolbarHelper.setImmersive(false);
        }
    }

    /**
     * 当虚拟按键存在时，布局不会沉浸到虚拟按键部分
     * 当虚拟按键不存在，布局沉浸全屏幕
     * 适配到android 4.4
     */
    protected void initState() {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); //全屏显示

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS); //透明导航栏
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    protected abstract @LayoutRes int getLayoutView();
    protected abstract void initView();
    protected abstract void initListener();
    protected abstract void initData();

}
