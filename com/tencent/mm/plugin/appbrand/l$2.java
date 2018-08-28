package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class l$2 implements a {
    final /* synthetic */ l fdY;
    final /* synthetic */ String fdZ;

    l$2(l lVar, String str) {
        this.fdY = lVar;
        this.fdZ = str;
    }

    public final void qe(String str) {
        x.i("MicroMsg.AppBrandService", "inject module(%s) success", new Object[]{this.fdZ});
        h.mEJ.a(370, 31, 1, false);
    }

    public final void fM(String str) {
        x.e("MicroMsg.AppBrandService", "inject module(%s) script failed: %s", new Object[]{this.fdZ, str});
        h.mEJ.a(370, 32, 1, false);
    }
}
