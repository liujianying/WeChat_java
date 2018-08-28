package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.c;

class g$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ c fGB;
    final /* synthetic */ g fZF;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.page.a.c fZz;

    g$1(g gVar, com.tencent.mm.plugin.appbrand.page.a.c cVar, c cVar2, int i) {
        this.fZF = gVar;
        this.fZz = cVar;
        this.fGB = cVar2;
        this.doP = i;
    }

    public final void run() {
        this.fZF.a(this.fZz, this.fGB, this.doP);
    }
}
