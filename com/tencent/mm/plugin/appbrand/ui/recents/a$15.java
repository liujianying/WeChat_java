package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

class a$15 extends LinearLayoutManager {
    final /* synthetic */ a gyS;

    a$15(a aVar) {
        this.gyS = aVar;
        super(1);
    }

    public final void a(RecyclerView recyclerView, int i) {
        l lVar = new l(this.gyS.getActivity(), a.n(this.gyS));
        lVar.Sv = i;
        a(lVar);
    }

    public final boolean eY() {
        return false;
    }
}
