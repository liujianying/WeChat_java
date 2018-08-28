package android.support.v4.widget;

import android.database.DataSetObserver;

class e$b extends DataSetObserver {
    final /* synthetic */ e zb;

    private e$b(e eVar) {
        this.zb = eVar;
    }

    /* synthetic */ e$b(e eVar, byte b) {
        this(eVar);
    }

    public final void onChanged() {
        this.zb.yT = true;
        this.zb.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        this.zb.yT = false;
        this.zb.notifyDataSetInvalidated();
    }
}
