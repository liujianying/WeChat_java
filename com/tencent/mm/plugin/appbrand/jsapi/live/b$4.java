package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.page.p$d;
import com.tencent.mm.plugin.appbrand.page.p.e;
import com.tencent.mm.plugin.appbrand.page.p.f;

class b$4 implements e {
    final /* synthetic */ p fJO;
    final /* synthetic */ AppBrandLivePlayerView fRH;
    final /* synthetic */ b fRI;
    final /* synthetic */ f fRJ;
    final /* synthetic */ p$d fRK;

    b$4(b bVar, AppBrandLivePlayerView appBrandLivePlayerView, p pVar, f fVar, p$d p_d) {
        this.fRI = bVar;
        this.fRH = appBrandLivePlayerView;
        this.fJO = pVar;
        this.fRJ = fVar;
        this.fRK = p_d;
    }

    public final void onDestroy() {
        this.fRH.ua();
        this.fJO.b(this.fRJ);
        this.fJO.b(this.fRK);
        this.fJO.b(this);
    }
}
