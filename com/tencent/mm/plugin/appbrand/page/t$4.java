package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.r.i$a;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class t$4 implements i$a {
    final /* synthetic */ t goK;

    t$4(t tVar) {
        this.goK = tVar;
    }

    public final void qe(String str) {
        h.mEJ.a(370, 3, 1, false);
    }

    public final void fM(String str) {
        int i = 0;
        x.e("MicroMsg.AppBrandWebView", "Inject SDK Page Script Failed: %s", new Object[]{str});
        h.mEJ.a(370, 2, 1, false);
        a.G(t.a(this.goK), 24, 0);
        int i2 = -1;
        if (t.b(this.goK) != null) {
            i = t.b(this.goK).fcu.frm.fii;
            i2 = t.b(this.goK).fcu.frm.fih;
        }
        a.a(t.a(this.goK), i, i2, 370, 2);
    }
}
