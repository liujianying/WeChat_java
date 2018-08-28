package com.tencent.mm.plugin.appbrand.jsapi.c;

import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.c.a.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.sdk.platformtools.x;

class c$2 extends b {
    final /* synthetic */ l fCl;
    final /* synthetic */ c fQD;

    c$2(c cVar, l lVar) {
        this.fQD = cVar;
        this.fCl = lVar;
    }

    public final void onDestroy() {
        x.i("MicroMsg.JsApiStartBeaconDiscovery", "onDestroy");
        e.b(this.fCl.mAppId, this);
        a tz = a.tz(this.fCl.mAppId);
        if (tz != null) {
            tz.wk();
            a.remove(this.fCl.mAppId);
        }
        this.fQD.fQA = null;
    }
}
