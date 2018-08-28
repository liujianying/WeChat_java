package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.jsapi.c;

class b$1 implements Runnable {
    final /* synthetic */ int doP;
    final /* synthetic */ c fGB;
    final /* synthetic */ b fZA;
    final /* synthetic */ com.tencent.mm.plugin.appbrand.page.a.c fZz;

    b$1(b bVar, com.tencent.mm.plugin.appbrand.page.a.c cVar, c cVar2, int i) {
        this.fZA = bVar;
        this.fZz = cVar;
        this.fGB = cVar2;
        this.doP = i;
    }

    public final void run() {
        this.fZA.a(this.fZz, this.fGB, this.doP);
    }
}
