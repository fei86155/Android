package com.example.android.view.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;
import com.example.android.R;

import java.util.EnumMap;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/27 10:00
 * Update Date:
 * Modified By:
 * Description:
 */
public class MultiStatusLayout extends ConstraintLayout {
    private static final int STATE_CONTENT_VALUE = 1;
    private static final int STATE_LOADING_VALUE = 2;
    private static final int STATE_NO_DATA_VALUE = 3;
    private static final int STATE_NO_SEARCH_RESULT_VALUE = 4;
    private static final int STATE_NEED_LOGIN_VALUE = 5;
    private static final int STATE_NETWORK_ERROR_VALUE = 6;
    private static final int STATE_UNKNOWN_ERROR_VALUE = 7;
    private ViewState mCurrentViewState;

    public enum ViewState {
        STATE_CONTENT_VALUE,
        STATE_LOADING_VALUE,
        STATE_NO_DATA_VALUE,
        STATE_NO_SEARCH_RESULT_VALUE,
        STATE_NEED_LOGIN_VALUE,
        STATE_NETWORK_ERROR_VALUE,
        STATE_UNKNOWN_ERROR_VALUE

    }

    private EnumMap<ViewState, View> viewMap = new EnumMap<ViewState, View>(ViewState.class);


    public MultiStatusLayout(Context context) {
        super(context);
        init(context);
    }

    public MultiStatusLayout(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public MultiStatusLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        TypedArray ta = context.obtainStyledAttributes(R.styleable.MultiStatusLayout);
        int loadingView = ta.getResourceId(R.styleable.MultiStatusLayout_loading_view, -1);
        if (loadingView > 0) {

        }

        int state = ta.getInt(R.styleable.MultiStatusLayout_init_view, 1);
        switch (state) {
            case STATE_CONTENT_VALUE:
                setCurrentViewState(ViewState.STATE_CONTENT_VALUE);
                break;
        }
        ta.recycle();
    }


    public void addViewByState(ViewState state, @DrawableRes int iconRes, @NonNull String desc, @Nullable String btnDesc, @Nullable OnClickListener listener) {
        View view = getLayoutView();

        ImageView ivLogo = view.findViewById(R.id.iv_logo);
        if (iconRes == 0 || iconRes == -1) {
            ivLogo.setVisibility(GONE);
        } else {
            ivLogo.setImageResource(iconRes);
        }

        ImageView ivLoading = view.findViewById(R.id.iv_loading);
        Glide.with(getContext()).load(R.drawable.ic_loading).into(ivLoading);
        ivLoading.setVisibility(state == ViewState.STATE_LOADING_VALUE ? VISIBLE : GONE);


        TextView ivDesc = view.findViewById(R.id.tv_desc);
        ivDesc.setText(desc);


        Button button = view.findViewById(R.id.btn_retry);
        if (listener == null) {
            button.setVisibility(GONE);
        } else {
            button.setOnClickListener(listener);
        }

        applyView(state, view);
    }

    private View getLayoutView() {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_multi_state, this, false);
    }

    private void applyView(ViewState state, View view) {
        View v = viewMap.get(state);
        if (v != null) {
            viewMap.remove(state);
        }

        viewMap.put(state, view);
        addView(view, view.getLayoutParams());
    }

    public void setCurrentViewState(ViewState state) {


        initView(state);

        mCurrentViewState = state;
    }

    private void initView(ViewState state) {
        for (ViewState viewState : viewMap.keySet()) {
            View view = viewMap.get(viewState);
            if (view != null) {
                view.setVisibility(state == viewState ? VISIBLE : state == ViewState.STATE_CONTENT_VALUE ? INVISIBLE : GONE);
            }
        }
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (isValidContentView(child)) viewMap.put(ViewState.STATE_CONTENT_VALUE, child);
        super.addView(child, index, params);
    }

    @Override
    public void addView(View child) {
        if (isValidContentView(child)) viewMap.put(ViewState.STATE_CONTENT_VALUE, child);
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        if (isValidContentView(child)) viewMap.put(ViewState.STATE_CONTENT_VALUE, child);
        super.addView(child, index);
    }

    @Override
    public void addView(View child, int width, int height) {
        if (isValidContentView(child)) viewMap.put(ViewState.STATE_CONTENT_VALUE, child);
        super.addView(child, width, height);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        if (isValidContentView(child)) viewMap.put(ViewState.STATE_CONTENT_VALUE, child);
        super.addView(child, params);
    }

    private boolean isValidContentView(View child) {
        if (child == null) {
            return false;
        }
        if (viewMap.get(ViewState.STATE_CONTENT_VALUE) != null) {
            return false;
        }

        return true;
    }
}
