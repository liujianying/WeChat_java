package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;

class k$a extends c {
    private k$a() {
    }

    /* synthetic */ k$a(byte b) {
        this();
    }

    public final c b(t tVar, int i) {
        super.b(tVar, i);
        this.RZ = i;
        return this;
    }

    final boolean aop() {
        return (this.RZ & 2048) > 0;
    }
}
