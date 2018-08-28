package com.tencent.mm.ui.base.preference;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;

class i$3 implements OnItemLongClickListener {
    final /* synthetic */ i tDe;

    i$3(i iVar) {
        this.tDe = iVar;
    }

    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < i.e(this.tDe).getHeaderViewsCount()) {
            return false;
        }
        i.d(this.tDe).getItem(i - i.e(this.tDe).getHeaderViewsCount());
        i.d(this.tDe);
        i.e(this.tDe);
        return i.csm();
    }
}
