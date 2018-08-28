package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.g;

class i$3 implements a<Void, Void> {
    final /* synthetic */ i fiU;

    i$3(i iVar) {
        this.fiU = iVar;
    }

    private Void acs() {
        g.cBF().ct(null);
        synchronized (this.fiU) {
            i.b(this.fiU);
        }
        return null;
    }
}
