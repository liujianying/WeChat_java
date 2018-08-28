package com.tencent.mm.plugin.appbrand.game.d;

import com.tencent.mm.plugin.appbrand.config.d$a;
import com.tencent.mm.plugin.appbrand.config.d.b;
import com.tencent.mm.plugin.appbrand.l;

class a$1 implements d$a {
    final /* synthetic */ int doP;
    final /* synthetic */ l fCl;
    final /* synthetic */ a fCm;

    a$1(a aVar, l lVar, int i) {
        this.fCm = aVar;
        this.fCl = lVar;
        this.doP = i;
    }

    public final void a(b bVar, boolean z) {
        this.fCl.E(this.doP, this.fCm.f(z ? "ok" : "fail", null));
        if (z) {
            this.fCl.fdO.fcz.agI();
        }
    }
}
