package com.tencent.mm.plugin.appbrand.i;

import com.tencent.mm.plugin.appbrand.i.a.a;
import com.tencent.mm.plugin.appbrand.i.a.b;

class b$1 implements Runnable {
    final /* synthetic */ String gkp;
    final /* synthetic */ boolean gkq;
    final /* synthetic */ b gkr;
    final /* synthetic */ a gks;
    final /* synthetic */ b gkt;

    b$1(b bVar, String str, boolean z, b bVar2, a aVar) {
        this.gkt = bVar;
        this.gkp = str;
        this.gkq = z;
        this.gkr = bVar2;
        this.gks = aVar;
    }

    public final void run() {
        this.gkt.a(this.gkp, this.gkq, this.gkr, this.gks);
    }
}
