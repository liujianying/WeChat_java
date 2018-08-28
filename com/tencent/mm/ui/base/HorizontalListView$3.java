package com.tencent.mm.ui.base;

import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;

class HorizontalListView$3 extends SimpleOnGestureListener {
    final /* synthetic */ HorizontalListView tsN;

    HorizontalListView$3(HorizontalListView horizontalListView) {
        this.tsN = horizontalListView;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        return this.tsN.crg();
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return this.tsN.aC(f);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this.tsN) {
            HorizontalListView horizontalListView = this.tsN;
            horizontalListView.tsD += (int) f;
        }
        this.tsN.requestLayout();
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        Rect rect = new Rect();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.tsN.getChildCount()) {
                break;
            }
            View childAt = this.tsN.getChildAt(i2);
            rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                if (HorizontalListView.c(this.tsN) != null) {
                    HorizontalListView.c(this.tsN).onItemClick(this.tsN, childAt, (HorizontalListView.d(this.tsN) + 1) + i2, this.tsN.Do.getItemId((HorizontalListView.d(this.tsN) + 1) + i2));
                }
                if (HorizontalListView.e(this.tsN) != null) {
                    HorizontalListView.e(this.tsN).onItemSelected(this.tsN, childAt, (HorizontalListView.d(this.tsN) + 1) + i2, this.tsN.Do.getItemId((HorizontalListView.d(this.tsN) + 1) + i2));
                }
            } else {
                i = i2 + 1;
            }
        }
        return true;
    }
}
