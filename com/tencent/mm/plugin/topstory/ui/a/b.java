package com.tencent.mm.plugin.topstory.ui.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public final class b extends LinearLayoutManager {
    public b() {
        super(1);
    }

    public final void a(RecyclerView recyclerView, int i) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.Sv = i;
        a(aVar);
    }
}
