package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.ah.c;
import com.tencent.mm.plugin.appbrand.appcache.base.a;
import com.tencent.mm.pluginsdk.g.a.c.f.d;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.pluginsdk.g.a.c.u;

final class ah$b extends n {
    final /* synthetic */ ah fho;

    ah$b(ah ahVar) {
        this.fho = ahVar;
        super(new u("WxaPkgDownloaderPool", "WxaPkgDownloaderThread"), new ah$d(ahVar));
    }

    public final void shutdown() {
        super.shutdown();
        ((ah$d) this.qDm).fhs.getLooper().quit();
    }

    protected final d a(l lVar) {
        c cVar = new c((a) lVar);
        cVar.qDp = this.qDm;
        return cVar;
    }

    protected final int b(l lVar) {
        int b = super.b(lVar);
        if (b != 1) {
            return b;
        }
        super.b(lVar);
        return 2;
    }
}
