package com.tencent.mm.ui.gridviewheaders;

import android.database.DataSetObserver;

class c$1 extends DataSetObserver {
    final /* synthetic */ c utW;

    c$1(c cVar) {
        this.utW = cVar;
    }

    public final void onChanged() {
        int i = 0;
        c cVar = this.utW;
        cVar.mCount = 0;
        int czk = cVar.utS.czk();
        if (czk == 0) {
            cVar.mCount = cVar.utS.getCount();
        } else {
            while (i < czk) {
                cVar.mCount += cVar.utS.FW(i) + cVar.mNumColumns;
                i++;
            }
        }
        this.utW.notifyDataSetChanged();
    }

    public final void onInvalidated() {
        c.a(this.utW).clear();
        this.utW.notifyDataSetInvalidated();
    }
}
