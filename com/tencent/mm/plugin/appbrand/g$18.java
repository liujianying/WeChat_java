package com.tencent.mm.plugin.appbrand;

import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.debugger.n;
import com.tencent.mm.plugin.appbrand.g.2;
import com.tencent.mm.plugin.appbrand.game.d;
import com.tencent.mm.plugin.appbrand.i.a.c;
import com.tencent.mm.plugin.appbrand.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.c.e;
import com.tencent.mm.sdk.platformtools.bi;

class g$18 implements Runnable {
    final /* synthetic */ g fdd;

    g$18(g gVar) {
        this.fdd = gVar;
    }

    public final void run() {
        boolean z;
        g gVar = this.fdd;
        gVar.fcJ.o(6, System.currentTimeMillis() - gVar.fct.startTime);
        AppBrandStatObject appBrandStatObject = gVar.fcE;
        String str = gVar.fct.fqx;
        gVar.a(appBrandStatObject);
        if (gVar.fcu == null || bi.cX(gVar.fcu.frm.fil)) {
            z = false;
        } else {
            z = true;
        }
        gVar.fcM = z ? new b(gVar) : new c();
        if (gVar.aaq()) {
            gVar.fcy = new d();
        } else if (gVar.aar()) {
            gVar.fcy = new n();
        } else {
            gVar.fcy = com.tencent.mm.plugin.appbrand.task.d.vw(gVar.mAppId);
            if (gVar.fcy == null) {
                gVar.fcy = new l();
            }
        }
        gVar.fcy.h(gVar);
        l.tk(gVar.mAppId);
        gVar.fcz = gVar.aaq() ? new com.tencent.mm.plugin.appbrand.game.page.c(gVar.fcq, gVar) : new com.tencent.mm.plugin.appbrand.page.n(gVar.fcq, gVar);
        gVar.fcz.setOnReadyListener(new 2(gVar));
        gVar.fcA.addView(gVar.fcz, 0);
        FrameLayout frameLayout = gVar.fcA;
        e eVar = new e(gVar.fcq);
        gVar.fcD = eVar;
        frameLayout.addView(eVar);
        gVar.fcz.sW(gVar.fct.fqx);
        gVar.fcJ.o(8, System.currentTimeMillis() - gVar.fct.startTime);
        gVar.fcy.init();
        gVar.a(gVar.fcu);
        gVar.jy(2);
        this.fdd.dti = true;
        g gVar2 = this.fdd;
        gVar2.mHandler.removeCallbacks(gVar2.fdc);
    }
}
