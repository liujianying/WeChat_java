package com.tencent.mm.ui.widget.sortlist;

import android.view.View;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.m;

class DragSortListView$g extends m {
    private int uOF;
    private int uOG;
    private float uOH;
    private float uOI;
    final /* synthetic */ DragSortListView uOr;

    /* synthetic */ DragSortListView$g(DragSortListView dragSortListView, int i, byte b) {
        this(dragSortListView, i);
    }

    private DragSortListView$g(DragSortListView dragSortListView, int i) {
        this.uOr = dragSortListView;
        super(dragSortListView, i, (byte) 0);
    }

    public final void onStart() {
        this.uOF = DragSortListView.g(this.uOr);
        this.uOG = DragSortListView.h(this.uOr);
        DragSortListView.a(this.uOr, 2);
        this.uOH = (float) (DragSortListView.d(this.uOr).y - cBm());
        this.uOI = (float) (DragSortListView.d(this.uOr).x - this.uOr.getPaddingLeft());
    }

    private int cBm() {
        int i = (DragSortListView.i(this.uOr) + this.uOr.getDividerHeight()) / 2;
        View childAt = this.uOr.getChildAt(this.uOF - this.uOr.getFirstVisiblePosition());
        if (childAt == null) {
            this.Ju = true;
            return -1;
        } else if (this.uOF == this.uOG) {
            return childAt.getTop();
        } else {
            if (this.uOF < this.uOG) {
                return childAt.getTop() - i;
            }
            return (childAt.getBottom() + i) - DragSortListView.j(this.uOr);
        }
    }

    public final void aG(float f) {
        int cBm = cBm();
        float paddingLeft = (float) (DragSortListView.d(this.uOr).x - this.uOr.getPaddingLeft());
        float f2 = 1.0f - f;
        if (f2 < Math.abs(((float) (DragSortListView.d(this.uOr).y - cBm)) / this.uOH) || f2 < Math.abs(paddingLeft / this.uOI)) {
            DragSortListView.d(this.uOr).y = cBm + ((int) (this.uOH * f2));
            DragSortListView.d(this.uOr).x = this.uOr.getPaddingLeft() + ((int) (this.uOI * f2));
            DragSortListView.f(this.uOr);
        }
    }

    public final void onStop() {
        DragSortListView.k(this.uOr);
    }
}
