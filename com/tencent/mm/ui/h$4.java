package com.tencent.mm.ui;

import com.tencent.mm.g.a.tt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class h$4 extends c<tt> {
    final /* synthetic */ h tiG;

    h$4(h hVar) {
        this.tiG = hVar;
        this.sFo = tt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        this.tiG.getContentView().post(new 1(this));
        return false;
    }
}
