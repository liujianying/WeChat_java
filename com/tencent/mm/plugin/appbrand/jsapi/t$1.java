package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.canvas.widget.a$a;
import com.tencent.mm.plugin.appbrand.l;

class t$1 implements a$a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ t fFL;

    t$1(t tVar, l lVar, int i) {
        this.fFL = tVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void adq() {
        this.fCl.E(this.doP, this.fFL.f("ok", null));
    }
}
