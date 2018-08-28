package com.tencent.mm.ui;

import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

class Sort3rdAppUI$2 implements h {
    final /* synthetic */ Sort3rdAppUI tqr;

    Sort3rdAppUI$2(Sort3rdAppUI sort3rdAppUI) {
        this.tqr = sort3rdAppUI;
    }

    public final void cu(int i, int i2) {
        f fVar = (f) Sort3rdAppUI.a(this.tqr).getItem(i);
        Sort3rdAppUI.a(this.tqr).remove(fVar);
        Sort3rdAppUI.a(this.tqr).insert(fVar, i2);
    }
}
