package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class HorizontalListView$1 extends DataSetObserver {
    final /* synthetic */ HorizontalListView tsN;

    HorizontalListView$1(HorizontalListView horizontalListView) {
        this.tsN = horizontalListView;
    }

    public final void onChanged() {
        synchronized (this.tsN) {
            HorizontalListView.a(this.tsN);
        }
        this.tsN.invalidate();
        this.tsN.requestLayout();
    }

    public final void onInvalidated() {
        HorizontalListView.b(this.tsN);
        this.tsN.invalidate();
        this.tsN.requestLayout();
    }
}
