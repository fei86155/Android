package com.example.android.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Author:      xxbi
 * Create Date: Created in 2020/9/28 17:25
 * Update Date:
 * Modified By:
 * Description:
 */
public class SlideDeleteRecyclerView extends RecyclerView {
    private Rect rect;
    private View mView;

    public SlideDeleteRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public SlideDeleteRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SlideDeleteRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (rect == null) {
            rect = new Rect();
        }
    }


    float rawX;
    float rawY;
    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rawX = e.getX();
                rawY = e.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                return true;

            case MotionEvent.ACTION_UP:
                break;
        }

        int pos = getTouchViewPosition((int) e.getX(), (int) e.getY());
        mView = getChildAt(pos - ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition());
        return super.onInterceptTouchEvent(e);
    }


    @Override
    public boolean onTouchEvent(MotionEvent e) {

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(e.getX() - rawX) > Math.abs(e.getY() - rawY)) {
                    mView.scrollBy(Math.abs((int)(e.getX() - rawX)), 0);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return super.onTouchEvent(e);
    }

    /**
     * 获取点击的item view在adapter中的位置
     *
     * @param x
     * @param y
     * @return
     */
    private int getTouchViewPosition(int x, int y) {
        int visibleViewCount = getChildCount();
        int firstVisibleViewPos = ((LinearLayoutManager) getLayoutManager()).findFirstVisibleItemPosition();
        for (int i = 0; i < visibleViewCount; i++) {
            View view = getChildAt(i);
            view.getHitRect(rect);
            if (rect.contains(x, y)) {
                return firstVisibleViewPos + i;
            }
        }
        return -1;
    }


}
