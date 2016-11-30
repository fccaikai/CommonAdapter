package com.kcode.adapter;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by caik on 2016/11/30.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private int mOrientation;
    private Drawable mDivider;

    private static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;
    private static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public DividerItemDecoration(Drawable mDivider, int mOrientation) {
        this.mDivider = mDivider;
        setOrientation(mOrientation);
    }

    private void setOrientation(int orientation) {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST) {
            throw new IllegalArgumentException("invalid orientation");
        }

        this.mOrientation = orientation;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == HORIZONTAL_LIST) {
            drawHorizontal(c, parent);
        }else {
            drawVertical(c, parent);
        }
    }

    private void drawHorizontal(Canvas c, RecyclerView parent) {

    }

    private void drawVertical(Canvas c, RecyclerView parent) {

    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == VERTICAL_LIST) {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        } else {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
