package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

final class f$a extends DataSetObserver {
    final /* synthetic */ f uuD;

    private f$a(f fVar) {
        this.uuD = fVar;
    }

    /* synthetic */ f$a(f fVar, byte b) {
        this(fVar);
    }

    public final void onChanged() {
        f.a(this.uuD, this.uuD.a(f.a(this.uuD)));
        this.uuD.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        f.a(this.uuD, this.uuD.a(f.a(this.uuD)));
        this.uuD.notifyDataSetInvalidated();
    }
}
