package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;
import android.view.View;

class DragSortListView$d implements Runnable {
    boolean uIg = false;
    int uOA;
    private float uOB;
    final /* synthetic */ DragSortListView uOr;
    private boolean uOu;
    private long uOv;
    private long uOw;
    private int uOx;
    private float uOy;
    private long uOz;

    DragSortListView$d(DragSortListView dragSortListView) {
        this.uOr = dragSortListView;
    }

    public final void GJ(int i) {
        if (!this.uIg) {
            this.uOu = false;
            this.uIg = true;
            this.uOz = SystemClock.uptimeMillis();
            this.uOv = this.uOz;
            this.uOA = i;
            this.uOr.post(this);
        }
    }

    public final void cBl() {
        this.uOr.removeCallbacks(this);
        this.uIg = false;
    }

    public final void run() {
        if (this.uOu) {
            this.uIg = false;
            return;
        }
        View childAt;
        int firstVisiblePosition = this.uOr.getFirstVisiblePosition();
        int lastVisiblePosition = this.uOr.getLastVisiblePosition();
        int count = this.uOr.getCount();
        int paddingTop = this.uOr.getPaddingTop();
        int height = (this.uOr.getHeight() - paddingTop) - this.uOr.getPaddingBottom();
        int min = Math.min(DragSortListView.e(this.uOr), DragSortListView.r(this.uOr) + DragSortListView.c(this.uOr));
        int max = Math.max(DragSortListView.e(this.uOr), DragSortListView.r(this.uOr) - DragSortListView.c(this.uOr));
        if (this.uOA == 0) {
            childAt = this.uOr.getChildAt(0);
            if (childAt == null) {
                this.uIg = false;
                return;
            } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                this.uIg = false;
                return;
            } else {
                this.uOB = DragSortListView.u(this.uOr).aF((DragSortListView.s(this.uOr) - ((float) max)) / DragSortListView.t(this.uOr));
            }
        } else {
            View childAt2 = this.uOr.getChildAt(lastVisiblePosition - firstVisiblePosition);
            if (childAt2 == null) {
                this.uIg = false;
                return;
            } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                this.uOB = -DragSortListView.u(this.uOr).aF((((float) min) - DragSortListView.v(this.uOr)) / DragSortListView.w(this.uOr));
            } else {
                this.uIg = false;
                return;
            }
        }
        this.uOw = SystemClock.uptimeMillis();
        this.uOy = (float) (this.uOw - this.uOv);
        this.uOx = Math.round(this.uOB * this.uOy);
        if (this.uOx >= 0) {
            this.uOx = Math.min(height, this.uOx);
            lastVisiblePosition = firstVisiblePosition;
        } else {
            this.uOx = Math.max(-height, this.uOx);
        }
        childAt = this.uOr.getChildAt(lastVisiblePosition - firstVisiblePosition);
        firstVisiblePosition = childAt.getTop() + this.uOx;
        if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
            firstVisiblePosition = paddingTop;
        }
        DragSortListView.a(this.uOr, true);
        this.uOr.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
        this.uOr.layoutChildren();
        this.uOr.invalidate();
        DragSortListView.a(this.uOr, false);
        DragSortListView.c(this.uOr, lastVisiblePosition, childAt);
        this.uOv = this.uOw;
        this.uOr.post(this);
    }
}
