package com.tencent.mm.plugin.appbrand.appcache.a.b;

import com.tencent.mm.ab.a.a;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.a.b.i.2;
import com.tencent.mm.plugin.appbrand.launching.j.d;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.vending.g.b;
import java.util.concurrent.atomic.AtomicBoolean;

class i$2$1 implements d {
    final /* synthetic */ boolean fiE;
    final /* synthetic */ int fiF;
    final /* synthetic */ b fiG;
    final /* synthetic */ AtomicBoolean fiW;
    final /* synthetic */ 2 fiX;

    i$2$1(2 2, boolean z, int i, AtomicBoolean atomicBoolean, b bVar) {
        this.fiX = 2;
        this.fiE = z;
        this.fiF = i;
        this.fiW = atomicBoolean;
        this.fiG = bVar;
    }

    public final void a(a<akm> aVar) {
        if (!com.tencent.mm.plugin.appbrand.j.a.b(aVar)) {
            int i = this.fiE ? 50 : 49;
            int i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
            com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) this.fiF, (long) i);
            this.fiW.set(true);
            this.fiG.resume();
        }
    }

    public final void b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (wxaPkgWrappingInfo != null) {
            ((com.tencent.mm.plugin.appbrand.appcache.a.d.d) e.x(com.tencent.mm.plugin.appbrand.appcache.a.d.d.class)).a(this.fiX.fiV, new String[0]);
        }
        if (!this.fiW.get()) {
            int i = wxaPkgWrappingInfo != null ? this.fiE ? 52 : 47 : this.fiE ? 53 : 48;
            int i2 = com.tencent.mm.plugin.appbrand.appcache.a.c.a.fiY;
            com.tencent.mm.plugin.appbrand.appcache.a.c.a.n((long) this.fiF, (long) i);
            this.fiG.resume();
        }
    }
}
