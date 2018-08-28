package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class HorizontalListViewV2$2 extends DataSetObserver {
    final /* synthetic */ HorizontalListViewV2 tti;

    HorizontalListViewV2$2(HorizontalListViewV2 horizontalListViewV2) {
        this.tti = horizontalListViewV2;
    }

    public final void onChanged() {
        HorizontalListViewV2.b(this.tti);
        HorizontalListViewV2.c(this.tti);
        HorizontalListViewV2.d(this.tti);
        this.tti.invalidate();
        this.tti.requestLayout();
    }

    public final void onInvalidated() {
        HorizontalListViewV2.c(this.tti);
        HorizontalListViewV2.d(this.tti);
        HorizontalListViewV2.e(this.tti);
        this.tti.invalidate();
        this.tti.requestLayout();
    }
}
