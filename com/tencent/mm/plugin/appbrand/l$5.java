package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.sdk.platformtools.x;

class l$5 implements a {
    final /* synthetic */ l fdY;

    l$5(l lVar) {
        this.fdY = lVar;
    }

    public final void qe(String str) {
        x.i("MicroMsg.AppBrandService", "Inject performanceJs Script Success");
    }

    public final void fM(String str) {
        x.e("MicroMsg.AppBrandService", "Inject performanceJs Script Failed");
    }
}
