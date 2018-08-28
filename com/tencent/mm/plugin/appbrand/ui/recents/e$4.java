package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.appusage.i;
import com.tencent.mm.plugin.appbrand.compat.a.a;
import com.tencent.mm.plugin.appbrand.launching.precondition.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.a.j;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class e$4 implements Runnable {
    final /* synthetic */ e gAf;

    e$4(e eVar) {
        this.gAf = eVar;
    }

    public final void run() {
        int i = 0;
        if (e.e(this.gAf) != null) {
            ako acT = i.acT();
            if (acT != null) {
                int i2 = acT.rNt == 1 ? 1 : 0;
                if (i2 != 0) {
                    avr avr = acT.rNu;
                    if (avr == null) {
                        x.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram but invalid appInfo, just return");
                        return;
                    }
                    if (b.chp()) {
                        i = avr.type;
                    }
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.scene = 1001;
                    g.ghE.a(e.e(this.gAf), avr.username, null, avr.path, i, avr.rkb, appBrandStatObject, null, null);
                } else if (bi.oW(acT.rNi)) {
                    x.e("MicroMsg.AppBrandLauncherRecentsListHeader", "onCellClicked, useMiniProgram false, url empty, just return");
                    return;
                } else {
                    ((a) com.tencent.mm.kernel.g.l(a.class)).S(e.e(this.gAf), acT.rNi);
                }
                e.f(this.gAf);
                j jVar = new j();
                jVar.grT = j.b.gsg;
                jVar.grU = acT.gTo;
                jVar.grV = acT.rNg;
                jVar.grX = i2 != 0 ? j.a.gsb : j.a.grY;
                jVar.xP();
            }
        }
    }
}
