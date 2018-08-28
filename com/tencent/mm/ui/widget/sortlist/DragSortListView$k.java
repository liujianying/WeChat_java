package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.m;

class DragSortListView$k extends m {
    private int hOK;
    private float uOL;
    private float uOM;
    private float uON;
    private int uOO;
    private int uOP;
    private int uOQ;
    final /* synthetic */ DragSortListView uOr;

    /* synthetic */ DragSortListView$k(DragSortListView dragSortListView, int i, byte b) {
        this(dragSortListView, i);
    }

    private DragSortListView$k(DragSortListView dragSortListView, int i) {
        this.uOr = dragSortListView;
        super(dragSortListView, i, (byte) 0);
        this.uOO = -1;
        this.uOP = -1;
    }

    public final void onStart() {
        int i = -1;
        this.uOO = -1;
        this.uOP = -1;
        this.hOK = DragSortListView.l(this.uOr);
        this.uOQ = DragSortListView.m(this.uOr);
        DragSortListView.a(this.uOr, 1);
        this.uOL = (float) DragSortListView.d(this.uOr).x;
        if (DragSortListView.n(this.uOr)) {
            float width = ((float) this.uOr.getWidth()) * 2.0f;
            if (DragSortListView.o(this.uOr) == 0.0f) {
                DragSortListView dragSortListView = this.uOr;
                if (this.uOL >= 0.0f) {
                    i = 1;
                }
                DragSortListView.a(dragSortListView, ((float) i) * width);
                return;
            }
            float f = width * 2.0f;
            if (DragSortListView.o(this.uOr) < 0.0f && DragSortListView.o(this.uOr) > (-f)) {
                DragSortListView.a(this.uOr, -f);
                return;
            } else if (DragSortListView.o(this.uOr) > 0.0f && DragSortListView.o(this.uOr) < f) {
                DragSortListView.a(this.uOr, f);
                return;
            } else {
                return;
            }
        }
        DragSortListView.p(this.uOr);
    }

    public final void aG(float f) {
        float f2 = 1.0f - f;
        int firstVisiblePosition = this.uOr.getFirstVisiblePosition();
        View childAt = this.uOr.getChildAt(this.hOK - firstVisiblePosition);
        if (DragSortListView.n(this.uOr)) {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
            if (uptimeMillis != 0.0f) {
                float o = DragSortListView.o(this.uOr) * uptimeMillis;
                int width = this.uOr.getWidth();
                DragSortListView.a(this.uOr, ((((float) (DragSortListView.o(this.uOr) > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width)) + DragSortListView.o(this.uOr));
                this.uOL += o;
                DragSortListView.d(this.uOr).x = (int) this.uOL;
                if (this.uOL < ((float) width) && this.uOL > ((float) (-width))) {
                    this.mStartTime = SystemClock.uptimeMillis();
                    DragSortListView.f(this.uOr);
                    return;
                }
            }
            return;
        }
        if (childAt != null) {
            if (this.uOO == -1) {
                this.uOO = DragSortListView.b(this.uOr, this.hOK, childAt);
                this.uOM = (float) (childAt.getHeight() - this.uOO);
            }
            int max = Math.max((int) (this.uOM * f2), 1);
            LayoutParams layoutParams = childAt.getLayoutParams();
            layoutParams.height = max + this.uOO;
            childAt.setLayoutParams(layoutParams);
        }
        if (this.uOQ != this.hOK) {
            View childAt2 = this.uOr.getChildAt(this.uOQ - firstVisiblePosition);
            if (childAt2 != null) {
                if (this.uOP == -1) {
                    this.uOP = DragSortListView.b(this.uOr, this.uOQ, childAt2);
                    this.uON = (float) (childAt2.getHeight() - this.uOP);
                }
                int max2 = Math.max((int) (this.uON * f2), 1);
                LayoutParams layoutParams2 = childAt2.getLayoutParams();
                layoutParams2.height = max2 + this.uOP;
                childAt2.setLayoutParams(layoutParams2);
            }
        }
    }

    public final void onStop() {
        DragSortListView.q(this.uOr);
    }
}
