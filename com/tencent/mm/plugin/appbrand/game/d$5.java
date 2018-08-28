package com.tencent.mm.plugin.appbrand.game;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class d$5 implements a {
    final /* synthetic */ d fzU;

    d$5(d dVar) {
        this.fzU = dVar;
    }

    public final void qe(String str) {
        x.i("MicroMsg.WAGameAppService", "Inject SDK game Script suc: %s", new Object[]{str});
        if (d.n(this.fzU) != null) {
            d.p(this.fzU).fcJ.o(12, System.currentTimeMillis() - d.o(this.fzU));
        }
        h.mEJ.a(778, 27, 1, false);
    }

    public final void fM(String str) {
        x.e("MicroMsg.WAGameAppService", "Inject SDK game Script Failed: %s", new Object[]{str});
        if (d.q(this.fzU) != null) {
            d.r(this.fzU).fcJ.o(12, System.currentTimeMillis() - d.o(this.fzU));
        }
        h.mEJ.a(778, 26, 1, false);
        com.tencent.mm.plugin.appbrand.report.a.G(this.fzU.mAppId, 24, 0);
        com.tencent.mm.plugin.appbrand.report.a.a(this.fzU.mAppId, this.fzU.fdO.fcu.frm.fii, this.fzU.fdO.fcu.frm.fih, 778, 26);
    }
}
