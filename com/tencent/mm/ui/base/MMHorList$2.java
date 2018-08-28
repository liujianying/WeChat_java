package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class MMHorList$2 extends DataSetObserver {
    final /* synthetic */ MMHorList tvP;

    MMHorList$2(MMHorList mMHorList) {
        this.tvP = mMHorList;
    }

    public final void onChanged() {
        MMHorList.a(this.tvP);
        this.tvP.invalidate();
        this.tvP.requestLayout();
    }

    public final void onInvalidated() {
        MMHorList.b(this.tvP);
        this.tvP.invalidate();
        this.tvP.requestLayout();
    }
}
