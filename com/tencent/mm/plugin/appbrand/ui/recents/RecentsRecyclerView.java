package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;

class RecentsRecyclerView extends LoadMoreRecyclerView {
    private View gBa;

    public RecentsRecyclerView(Context context) {
        super(context);
        setChildrenDrawingOrderEnabled(true);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setChildrenDrawingOrderEnabled(true);
    }

    public RecentsRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setChildrenDrawingOrderEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.gBa == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        int indexOfChild = indexOfChild(this.gBa);
        if (indexOfChild < 0) {
            return super.getChildDrawingOrder(i, i2);
        }
        if (i2 == i - 1) {
            return indexOfChild;
        }
        if (i2 == indexOfChild) {
            return i - 1;
        }
        return super.getChildDrawingOrder(i, i2);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getItemAnimator() == null || !getItemAnimator().isRunning()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    final void bP(View view) {
        if (view.getParent() == this) {
            if (VERSION.SDK_INT >= 21) {
                view.setZ(1.0f);
            } else {
                this.gBa = view;
            }
        }
    }

    final void bQ(View view) {
        if (view.getParent() == this) {
            if (VERSION.SDK_INT >= 21) {
                view.setZ(0.0f);
            } else if (this.gBa == view) {
                this.gBa = null;
            }
        }
    }
}
