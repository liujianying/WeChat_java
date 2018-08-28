package com.tencent.mm.ui.base.sortview;

import android.database.DataSetObserver;

class BaseSortView$1 extends DataSetObserver {
    final /* synthetic */ BaseSortView tDO;

    BaseSortView$1(BaseSortView baseSortView) {
        this.tDO = baseSortView;
    }

    public final void onChanged() {
        if (BaseSortView.a(this.tDO) != null) {
            BaseSortView.a(this.tDO).av(BaseSortView.b(this.tDO).tDK);
        }
    }
}
