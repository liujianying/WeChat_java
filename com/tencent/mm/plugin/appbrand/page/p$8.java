package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.a;

class p$8 implements Runnable {
    final /* synthetic */ p gnH;

    p$8(p pVar) {
        this.gnH = pVar;
    }

    public final void run() {
        this.gnH.gnC.amF();
        t tVar = this.gnH.gns;
        tVar.fdO.fcJ.o(4, System.currentTimeMillis() - tVar.goA);
        AppBrandPerformanceManager.b(tVar.mAppId, 203, System.currentTimeMillis() - tVar.goG);
        a.a(tVar.mAppId, "Native", "PageLoad", tVar.goG, System.currentTimeMillis(), "");
    }
}
