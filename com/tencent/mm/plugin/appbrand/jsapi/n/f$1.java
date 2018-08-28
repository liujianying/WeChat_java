package com.tencent.mm.plugin.appbrand.jsapi.n;

import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic.a;

class f$1 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ f fZE;

    f$1(f fVar, l lVar) {
        this.fZE = fVar;
        this.fCl = lVar;
    }

    public final void onDestroy() {
        a.bO(this.fCl.mAppId, "");
    }
}
