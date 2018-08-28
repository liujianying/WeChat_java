package com.tencent.mm.bt.a;

import android.database.DataSetObserver;

class e$1 extends DataSetObserver {
    final /* synthetic */ e tes;

    e$1(e eVar) {
        this.tes = eVar;
    }

    public final void onChanged() {
        e.a(this.tes);
    }

    public final void onInvalidated() {
        e.b(this.tes);
    }
}
