package com.tencent.mm.plugin.appbrand.jsapi.live;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e$b;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;

class c$3 extends e$b {
    final /* synthetic */ p fJO;
    final /* synthetic */ AppBrandLivePusherView fRN;
    final /* synthetic */ c fRO;

    c$3(c cVar, AppBrandLivePusherView appBrandLivePusherView, p pVar) {
        this.fRO = cVar;
        this.fRN = appBrandLivePusherView;
        this.fJO = pVar;
    }

    public final void a(c cVar) {
        AppBrandLivePusherView appBrandLivePusherView = this.fRN;
        x.i("MicroMsg.AppBrandLivePusherView", "onAppBrandPause pauseType:%s", new Object[]{cVar});
        if (cVar == c.fcg || cVar == c.fcf || cVar == c.fcl) {
            appBrandLivePusherView.fRF.cQ(true);
        }
    }

    public final void onResume() {
        this.fRN.fRF.ajf();
    }

    public final void onDestroy() {
        e.b(this.fJO.mAppId, this);
    }
}
