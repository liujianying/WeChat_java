package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.r.i.a;
import com.tencent.mm.sdk.platformtools.x;

class l$3 implements a {
    final /* synthetic */ l fdY;

    l$3(l lVar) {
        this.fdY = lVar;
    }

    public final void qe(String str) {
        x.i("MicroMsg.AppBrandService", "Inject android.js Script Success");
    }

    public final void fM(String str) {
        x.e("MicroMsg.AppBrandService", "Inject android.js Script Failed");
    }
}
