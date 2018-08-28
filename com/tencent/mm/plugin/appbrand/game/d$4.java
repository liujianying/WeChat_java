package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements a {
    final /* synthetic */ d fzU;

    d$4(d dVar) {
        this.fzU = dVar;
    }

    public final void qe(String str) {
        x.i("MicroMsg.WAGameAppService", "Inject SDK WAGame Script suc: %s", new Object[]{str});
        if (d.i(this.fzU) != null) {
            d.k(this.fzU).fcJ.o(11, System.currentTimeMillis() - d.j(this.fzU));
        }
        h.mEJ.a(778, 15, 1, false);
    }

    public final void fM(String str) {
        x.e("MicroMsg.WAGameAppService", "Inject SDK WAGame Script Failed: %s", new Object[]{str});
        if (d.l(this.fzU) != null) {
            d.m(this.fzU).fcJ.o(11, System.currentTimeMillis() - d.j(this.fzU));
        }
        h.mEJ.a(778, 14, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.G(this.fzU.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.fzU.mAppId, this.fzU.fdO.fcu.frm.fii, this.fzU.fdO.fcu.frm.fih, 778, 14);
    }
}
