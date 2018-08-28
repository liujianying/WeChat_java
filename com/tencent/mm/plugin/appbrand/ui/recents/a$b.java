package com.tencent.mm.plugin.appbrand.ui.recents;

import android.support.v7.widget.RecyclerView$c;
import android.support.v7.widget.RecyclerView$e.a;

final class a$b extends RecyclerView$c implements a {
    final /* synthetic */ a gyS;

    private a$b(a aVar) {
        this.gyS = aVar;
    }

    /* synthetic */ a$b(a aVar, byte b) {
        this(aVar);
    }

    public final void ac(int i, int i2) {
        de(false);
    }

    public final void ad(int i, int i2) {
        de(true);
    }

    public final void ae(int i, int i2) {
        de(false);
    }

    public final void ga() {
        de(false);
    }

    private void de(boolean z) {
        this.gyS.u(new 1(this, z));
    }
}
