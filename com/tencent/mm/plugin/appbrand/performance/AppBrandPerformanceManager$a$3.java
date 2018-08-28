package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager.a;

class AppBrandPerformanceManager$a$3 extends b {
    final /* synthetic */ a gpz;

    AppBrandPerformanceManager$a$3(a aVar) {
        this.gpz = aVar;
    }

    public final void onDestroy() {
        super.onDestroy();
        a aVar = this.gpz;
        aVar.yr = false;
        e.b(aVar.mAppId, aVar.gpy);
        if (a.amg() && aVar.gpw != null) {
            d dVar = aVar.gpw;
            dVar.yr = false;
            dVar.gpM = 0;
            dVar.gpN = 0;
            dVar.btz.removeFrameCallback(dVar);
        }
    }

    public final void a(c cVar) {
        super.a(cVar);
        a aVar = this.gpz;
        aVar.fcO = true;
        if (a.amg() && aVar.gpw != null) {
            aVar.gpw.fcO = true;
        }
    }

    public final void onResume() {
        super.onResume();
        a aVar = this.gpz;
        aVar.fcO = false;
        if (a.amg() && aVar.gpw != null) {
            aVar.gpw.fcO = false;
        }
    }
}
