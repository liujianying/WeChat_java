package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;

class c$2 extends DataSetObserver {
    final /* synthetic */ c gKl;

    c$2(c cVar) {
        this.gKl = cVar;
    }

    public final void onChanged() {
        if (this.gKl.gJV.eZB.isShowing()) {
            this.gKl.mj(1);
        }
    }
}
