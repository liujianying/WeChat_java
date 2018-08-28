package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.r.i$a;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class l$6 implements i$a {
    final /* synthetic */ l fdY;

    l$6(l lVar) {
        this.fdY = lVar;
    }

    public final void qe(String str) {
        h.mEJ.a(370, 11, 1, false);
    }

    public final void fM(String str) {
        x.e("MicroMsg.AppBrandService", "Inject External Service Script Failed: %s", new Object[]{str});
        h.mEJ.a(370, 10, 1, false);
        a.G(l.b(this.fdY), 24, 0);
        a.a(l.b(this.fdY), this.fdY.fdO.fcu.frm.fii, this.fdY.fdO.fcu.frm.fih, 370, 10);
    }
}
